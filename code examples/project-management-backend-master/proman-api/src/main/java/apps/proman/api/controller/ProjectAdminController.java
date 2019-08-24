package apps.proman.api.controller;

import static apps.proman.api.controller.transformer.ProjectTransformer.*;
import static apps.proman.api.data.ResourceConstants.BASE_URL;
import static apps.proman.service.board.exception.BoardErrorCode.BRD_004;
import static apps.proman.service.board.exception.ProjectErrorCode.PRJ_003;
import static apps.proman.service.user.exception.UserErrorCode.USR_008;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import apps.proman.api.controller.ext.ResponseBuilder;
import apps.proman.api.exception.RestException;
import apps.proman.api.model.CreateBoardProjectRequest;
import apps.proman.api.model.CreateBoardProjectResponse;
import apps.proman.api.model.ProjectDetailsResponse;
import apps.proman.api.model.ProjectOperationRequest;
import apps.proman.api.model.ProjectOperationsRequest;
import apps.proman.api.model.ProjectStatusType;
import apps.proman.api.model.ProjectsSummaryResponse;
import apps.proman.api.model.UpdateBoardProjectRequest;
import apps.proman.service.board.business.BoardService;
import apps.proman.service.board.business.ProjectService;
import apps.proman.service.board.entity.BoardEntity;
import apps.proman.service.board.entity.ProjectEntity;
import apps.proman.service.board.entity.ProjectMemberEntity;
import apps.proman.service.board.model.BoardStatus;
import apps.proman.service.board.model.ProjectStatus;
import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.common.model.SearchResult;
import apps.proman.service.user.business.UserService;
import apps.proman.service.user.entity.UserEntity;
import apps.proman.service.user.model.UserStatus;

@RestController
@CrossOrigin
@RequestMapping(BASE_URL)
public class ProjectAdminController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = GET, path = "/boards/{board_id}/projects", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProjectsSummaryResponse> getProjects(@RequestHeader("authorization") String accessToken,
                                                               @PathVariable("board_id") final String boardUuid,
                                                               @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                               @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                                                               @RequestParam(value = "status", required = false) String status) {
        final SearchResult<ProjectEntity> searchResult;
        if (StringUtils.isEmpty(status)) {
            searchResult = projectService.findProjects(boardUuid, page, limit);
        } else {
            searchResult = projectService.findProjects(boardUuid, ProjectStatus.valueOf(toEnum(status).name()), page, limit);
        }
        return ResponseBuilder.ok().payload(toProjectsSummaryResponse(page, limit, searchResult)).build();
    }

    @RequestMapping(method = GET, path = "/boards/{board_id}/{projects}/{project_id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProjectDetailsResponse> getProject(@RequestHeader("authorization") String accessToken,
                                                             @PathVariable("board_id") final String boardUuid,
                                                             @PathVariable("project_id") final String projectUuid)
            throws ApplicationException {

        final ProjectEntity projectEntity = projectService.findProject(boardUuid, projectUuid);
        return ResponseBuilder.ok().payload(toProjectDetailsResponse(projectEntity)).build();
    }

    @RequestMapping(method = POST, path = "/boards/{board_id}/projects", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CreateBoardProjectResponse> createProject(@RequestHeader("authorization") String accessToken,
                                                                    @PathVariable("board_id") final String boardUuid,
                                                                    @RequestBody final CreateBoardProjectRequest createBoardProjectRequest) throws ApplicationException {

        final UserEntity existingUser = userService.findUserByUuid(createBoardProjectRequest.getOwnerId().toString());
        if (!UserStatus.ACTIVE.equals(UserStatus.get(existingUser.getStatus()))) {
            throw new ApplicationException(USR_008, UserStatus.get(existingUser.getStatus()));
        }

        final BoardEntity existingBoard = boardService.findBoard(boardUuid);
        if (BoardStatus.OPEN.getCode() != existingBoard.getStatus()) {
            throw new ApplicationException(BRD_004, BoardStatus.get(existingBoard.getStatus()));
        }

        final ProjectEntity projectEntity = toEntity(createBoardProjectRequest);
        projectEntity.setOwner(existingUser);
        projectEntity.setBoard(existingBoard);

        final ProjectEntity createdProject = projectService.createProject(projectEntity);
        return ResponseBuilder.created().payload(toResponse(createdProject)).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/boards/{board_id}/{projects}/{project_id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateProject(@RequestHeader("authorization") String accessToken,
                                        @PathVariable("board_id") final String boardUuid,
                                        @PathVariable("project_id") final String projectUuid,
                                        @RequestBody final UpdateBoardProjectRequest updatedBoardRequest) throws ApplicationException {

        final ProjectEntity projectEntity = toEntity(updatedBoardRequest);

        if (updatedBoardRequest.getOwnerId() != null) {
            final UserEntity existingUser = userService.findUserByUuid(updatedBoardRequest.getOwnerId().toString());
            if (!UserStatus.ACTIVE.equals(UserStatus.get(existingUser.getStatus()))) {
                throw new ApplicationException(USR_008, UserStatus.get(existingUser.getStatus()));
            }
            projectEntity.setOwner(existingUser);
        }

        projectService.updateProject(boardUuid, projectUuid, projectEntity);
        return ResponseBuilder.ok().build();
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/boards/{board_id}/{projects}/{project_id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity patchProject(@RequestHeader("authorization") String accessToken,
                                       @PathVariable("board_id") final String boardUuid,
                                       @PathVariable("project_id") final String projectUuid,
                                       @RequestBody final ProjectOperationsRequest projectOperationsRequest) throws ApplicationException {

        final Set<String> addedMembers = new HashSet<>();
        final Set<String> removedMembers = new HashSet<>();

        for (ProjectOperationRequest projectOperationRequest : projectOperationsRequest) {
            if (ProjectOperationRequest.PathEnum.STATUS.equals(projectOperationRequest.getPath())) {
                projectService.changeProjectStatus(boardUuid, projectUuid, ProjectStatus.valueOf(toEnum(projectOperationRequest.getValue()).name()));
            } else if (ProjectOperationRequest.OpEnum.ADD.equals(projectOperationRequest.getOp()) &&
                    ProjectOperationRequest.PathEnum.MEMBER.equals(projectOperationRequest.getPath())) {
                addedMembers.add(projectOperationRequest.getValue());
            } else if (ProjectOperationRequest.OpEnum.REMOVE.equals(projectOperationRequest.getOp()) &&
                    ProjectOperationRequest.PathEnum.MEMBER.equals(projectOperationRequest.getPath())) {
                removedMembers.add(projectOperationRequest.getValue());
            }
        }
        if (!addedMembers.isEmpty()) {
            projectService.addMembers(boardUuid, projectUuid, addedMembers);
        }
        if (!removedMembers.isEmpty()) {
            projectService.removeMembers(boardUuid, projectUuid, removedMembers);
        }

        return ResponseBuilder.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/boards/{board_id}/{projects}/{project_id}")
    public ResponseEntity deleteProject(@RequestHeader("authorization") String accessToken,
                                        @PathVariable("board_id") final String boardUuid,
                                        @PathVariable("project_id") final String projectUuid) throws ApplicationException {

        projectService.deleteProject(boardUuid, projectUuid);
        return ResponseBuilder.ok().build();
    }

    @RequestMapping(method = GET, path = "/boards/{board_id}/projects/{project_id}/members", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProjectsSummaryResponse> getProjectMembers(@RequestHeader("authorization") String accessToken,
                                                                     @PathVariable("board_id") final String boardUuid,
                                                                     @PathVariable("project_id") final String projectUuid) throws ApplicationException {

        final SearchResult<ProjectMemberEntity> searchResult = projectService.getProjectMembers(boardUuid, projectUuid);
        return ResponseBuilder.ok().payload(toProjectMembers(searchResult)).build();
    }

    private ProjectStatusType toEnum(final String status) {
        try {
            return ProjectStatusType.valueOf(status);
        } catch (IllegalArgumentException exc) {
            throw new RestException(PRJ_003, StringUtils.join(ProjectStatusType.values(), ","));
        }
    }

}
