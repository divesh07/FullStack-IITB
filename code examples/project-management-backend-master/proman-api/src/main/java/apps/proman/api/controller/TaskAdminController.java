package apps.proman.api.controller;

import static apps.proman.api.controller.transformer.TaskTransformer.toTaskDetailsResponse;
import static apps.proman.api.controller.transformer.TaskTransformer.toTasksSummaryResponse;
import static apps.proman.api.data.ResourceConstants.BASE_URL;
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
import apps.proman.api.controller.transformer.TaskTransformer;
import apps.proman.api.exception.RestException;
import apps.proman.api.model.CreateProjectTaskRequest;
import apps.proman.api.model.CreateProjectTaskResponse;
import apps.proman.api.model.ProjectStatusType;
import apps.proman.api.model.ProjectTaskDetailsResponse;
import apps.proman.api.model.ProjectTaskOperationRequest;
import apps.proman.api.model.ProjectTaskOperationsRequest;
import apps.proman.api.model.ProjectTasksSummaryResponse;
import apps.proman.api.model.UpdateProjectTaskRequest;
import apps.proman.service.board.business.ProjectService;
import apps.proman.service.board.business.TaskService;
import apps.proman.service.board.entity.ProjectEntity;
import apps.proman.service.board.entity.ProjectMemberEntity;
import apps.proman.service.board.entity.TaskEntity;
import apps.proman.service.board.exception.ProjectErrorCode;
import apps.proman.service.board.model.ProjectStatus;
import apps.proman.service.board.model.TaskStatus;
import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.common.model.SearchResult;
import apps.proman.service.user.model.UserStatus;

@RestController
@CrossOrigin
@RequestMapping(BASE_URL)
public class TaskAdminController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = GET, path = "/boards/{board_id}/projects/{project_id}/tasks", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProjectTasksSummaryResponse> getTasks(@RequestHeader("authorization") String accessToken,
                                                                @PathVariable("board_id") final String boardUuid,
                                                                @PathVariable("project_id") final String projectUuid,
                                                                @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                                @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                                                                @RequestParam(value = "status", required = false) String status) {
        final SearchResult<TaskEntity> searchResult;
        if (StringUtils.isEmpty(status)) {
            searchResult = taskService.findTasks(boardUuid, projectUuid, page, limit);
        } else {
            searchResult = taskService.findTasks(boardUuid, projectUuid, TaskStatus.valueOf(toEnum(status).name()), page, limit);
        }
        return ResponseBuilder.ok().payload(toTasksSummaryResponse(page, limit, searchResult)).build();
    }

    @RequestMapping(method = GET, path = "/boards/{board_id}/{projects}/{project_id}/tasks/{task_id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProjectTaskDetailsResponse> getTask(@RequestHeader("authorization") String accessToken,
                                                              @PathVariable("board_id") final String boardUuid,
                                                              @PathVariable("project_id") final String projectUuid,
                                                              @PathVariable("task_id") final String taskUuid)
            throws ApplicationException {

        final TaskEntity projectEntity = taskService.findTask(boardUuid, projectUuid, taskUuid);
        return ResponseBuilder.ok().payload(toTaskDetailsResponse(projectEntity)).build();
    }

    @RequestMapping(method = POST, path = "/boards/{board_id}/projects/{project_id}/tasks", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CreateProjectTaskResponse> createTask(@RequestHeader("authorization") String accessToken,
                                                                @PathVariable("board_id") final String boardUuid,
                                                                @PathVariable("project_id") final String projectUuid,
                                                                @RequestBody final CreateProjectTaskRequest createProjectTaskRequest) throws ApplicationException {

        final ProjectMemberEntity existingMember = getActiveMember(projectUuid, createProjectTaskRequest.getOwnerId().toString());

        final ProjectEntity existingProject = projectService.findProject(boardUuid, projectUuid);
        if (ProjectStatus.ON_HOLD.getCode() == existingProject.getStatus() || ProjectStatus.COMPLETED.getCode() == existingProject.getStatus()
                || ProjectStatus.DELETED.getCode() == existingProject.getStatus()) {
            throw new ApplicationException(ProjectErrorCode.PRJ_006, ProjectStatus.get(existingProject.getStatus()));
        }

        final TaskEntity taskEntity = TaskTransformer.toEntity(createProjectTaskRequest);
        taskEntity.setOwner(existingMember);
        taskEntity.setProject(existingProject);

        final TaskEntity createdProject = taskService.createTask(taskEntity);
        return ResponseBuilder.created().payload(TaskTransformer.toResponse(createdProject)).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/boards/{board_id}/{projects}/{project_id}/tasks/{task_id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateTask(@RequestHeader("authorization") String accessToken,
                                     @PathVariable("board_id") final String boardUuid,
                                     @PathVariable("project_id") final String projectUuid,
                                     @PathVariable("task_id") final String taskUuid,
                                     @RequestBody final UpdateProjectTaskRequest updateProjectTaskRequest) throws ApplicationException {

        final TaskEntity taskEntity = TaskTransformer.toEntity(updateProjectTaskRequest);

        if (updateProjectTaskRequest.getOwnerId() != null) {
            final ProjectMemberEntity existingMember = getActiveMember(projectUuid, updateProjectTaskRequest.getOwnerId().toString());
            taskEntity.setOwner(existingMember);
        }

        taskService.updateTask(boardUuid, projectUuid, taskUuid, taskEntity);
        return ResponseBuilder.ok().build();
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/boards/{board_id}/{projects}/{project_id}/tasks/{task_id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity patchTask(@RequestHeader("authorization") String accessToken,
                                    @PathVariable("board_id") final String boardUuid,
                                    @PathVariable("project_id") final String projectUuid,
                                    @PathVariable("task_id") final String taskUuid,
                                    @RequestBody final ProjectTaskOperationsRequest taskOperationsRequest) throws ApplicationException {

        final Set<String> addedWatchers = new HashSet<>();
        final Set<String> removedWatchers = new HashSet<>();

        for (ProjectTaskOperationRequest taskOperationRequest : taskOperationsRequest) {
            if (ProjectTaskOperationRequest.OpEnum.REPLACE.equals(taskOperationRequest.getOp()) &&
                    ProjectTaskOperationRequest.PathEnum.STATUS.equals(taskOperationRequest.getPath())) {
                taskService.changeTaskStatus(boardUuid, projectUuid, taskUuid, TaskStatus.valueOf(toEnum(taskOperationRequest.getValue()).name()));
            } else if (ProjectTaskOperationRequest.OpEnum.REPLACE.equals(taskOperationRequest.getOp()) &&
                    ProjectTaskOperationRequest.PathEnum.OWNER.equals(taskOperationRequest.getPath())) {
                taskService.changeTaskOwner(boardUuid, projectUuid, taskUuid, taskOperationRequest.getValue());
            } else if (ProjectTaskOperationRequest.OpEnum.ADD.equals(taskOperationRequest.getOp()) &&
                    ProjectTaskOperationRequest.PathEnum.EFFORT.equals(taskOperationRequest.getPath())) {
                taskService.addEffort(boardUuid, projectUuid, taskUuid, Integer.valueOf(taskOperationRequest.getValue()));
            } else if (ProjectTaskOperationRequest.OpEnum.ADD.equals(taskOperationRequest.getOp()) &&
                    ProjectTaskOperationRequest.PathEnum.WATCHER.equals(taskOperationRequest.getPath())) {
                addedWatchers.add(taskOperationRequest.getValue());
            } else if (ProjectTaskOperationRequest.OpEnum.REMOVE.equals(taskOperationRequest.getOp()) &&
                    ProjectTaskOperationRequest.PathEnum.WATCHER.equals(taskOperationRequest.getPath())) {
                removedWatchers.add(taskOperationRequest.getValue());
            } else if (ProjectTaskOperationRequest.OpEnum.REMOVE.equals(taskOperationRequest.getOp()) &&
                    ProjectTaskOperationRequest.PathEnum.EFFORT.equals(taskOperationRequest.getPath())) {
                taskService.removeEffort(boardUuid, projectUuid, taskUuid, Integer.valueOf(taskOperationRequest.getValue()));
            }
        }
        if (!addedWatchers.isEmpty()) {
            taskService.addWatchers(boardUuid, projectUuid, taskUuid, addedWatchers);
        }
        if (!removedWatchers.isEmpty()) {
            taskService.removeWatchers(boardUuid, projectUuid, taskUuid, removedWatchers);
        }

        return ResponseBuilder.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/boards/{board_id}/{projects}/{project_id}/tasks/{task_id}")
    public ResponseEntity deleteTask(@RequestHeader("authorization") String accessToken,
                                     @PathVariable("board_id") final String boardUuid,
                                     @PathVariable("project_id") final String projectUuid,
                                     @PathVariable("task_id") final String taskUuid) throws ApplicationException {

        taskService.deleteTask(boardUuid, projectUuid, taskUuid);
        return ResponseBuilder.ok().build();
    }

    private ProjectMemberEntity getActiveMember(final String projectUuid, final String memberUuid) throws ApplicationException {
        final ProjectMemberEntity existingMember = projectService.findMember(projectUuid, memberUuid);
        if (!UserStatus.ACTIVE.equals(UserStatus.get(existingMember.getMember().getStatus()))) {
            throw new ApplicationException(USR_008, UserStatus.get(existingMember.getMember().getStatus()));
        }
        return existingMember;
    }

    private ProjectStatusType toEnum(final String status) {
        try {
            return ProjectStatusType.valueOf(status);
        } catch (IllegalArgumentException exc) {
            throw new RestException(PRJ_003, StringUtils.join(ProjectStatusType.values(), ","));
        }
    }

}
