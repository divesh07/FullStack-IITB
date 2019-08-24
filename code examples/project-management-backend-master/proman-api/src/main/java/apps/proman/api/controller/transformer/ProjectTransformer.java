package apps.proman.api.controller.transformer;

import java.util.UUID;

import apps.proman.api.model.CreateBoardProjectRequest;
import apps.proman.api.model.CreateBoardProjectResponse;
import apps.proman.api.model.MemberStatusType;
import apps.proman.api.model.ProjectBoardSummaryType;
import apps.proman.api.model.ProjectDetailsResponse;
import apps.proman.api.model.ProjectMemberSummaryType;
import apps.proman.api.model.ProjectMembersSummaryResponse;
import apps.proman.api.model.ProjectOwnerDetailsType;
import apps.proman.api.model.ProjectOwnerType;
import apps.proman.api.model.ProjectStatusType;
import apps.proman.api.model.ProjectSummaryType;
import apps.proman.api.model.ProjectTaskSummaryType;
import apps.proman.api.model.ProjectTasksSummaryResponse;
import apps.proman.api.model.ProjectsSummaryResponse;
import apps.proman.api.model.UpdateBoardProjectRequest;
import apps.proman.service.board.entity.BoardEntity;
import apps.proman.service.board.entity.ProjectEntity;
import apps.proman.service.board.entity.ProjectMemberEntity;
import apps.proman.service.board.entity.TaskEntity;
import apps.proman.service.board.model.ProjectStatus;
import apps.proman.service.common.data.DateTimeProvider;
import apps.proman.service.common.model.SearchResult;
import apps.proman.service.user.entity.UserEntity;
import apps.proman.service.user.model.UserStatus;

public final class ProjectTransformer {

    private ProjectTransformer() {
    }

    public static ProjectEntity toEntity(final CreateBoardProjectRequest boardProjectRequest) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(boardProjectRequest.getName());
        projectEntity.setDescription(boardProjectRequest.getDescription());
        projectEntity.setStartAt(DateTimeProvider.parse(boardProjectRequest.getStartDate()));
        projectEntity.setEndAt(DateTimeProvider.parse(boardProjectRequest.getEndDate()));
        return projectEntity;
    }

    public static ProjectEntity toEntity(final UpdateBoardProjectRequest boardProjectRequest) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(boardProjectRequest.getName());
        projectEntity.setDescription(boardProjectRequest.getDescription());
        if(boardProjectRequest.getStartDate() != null) {
            projectEntity.setStartAt(DateTimeProvider.parse(boardProjectRequest.getStartDate()));
        }
        if(boardProjectRequest.getEndDate() != null) {
            projectEntity.setEndAt(DateTimeProvider.parse(boardProjectRequest.getEndDate()));
        }
        return projectEntity;
    }

    public static CreateBoardProjectResponse toResponse(final ProjectEntity projectEntity) {
        return new CreateBoardProjectResponse().id(UUID.fromString(projectEntity.getUuid()))
                .status(toStatus(projectEntity.getStatus()));
    }


    public static ProjectsSummaryResponse toProjectsSummaryResponse(final int page, final int limit, final SearchResult<ProjectEntity> searchResult) {

        ProjectsSummaryResponse projectsSummaryResponse = new ProjectsSummaryResponse().totalCount(searchResult.getTotalCount()).page(page).limit(limit);

        for (ProjectEntity entity : searchResult.getPayload()) {
            ProjectSummaryType summaryType = new ProjectSummaryType().id(UUID.fromString(entity.getUuid()))
                    .name(entity.getName()).description(entity.getDescription())
                    .board(toBoard(entity.getBoard()))
                    .owner(toOwner(entity.getOwner()))
                    .startDate(DateTimeProvider.format(entity.getStartAt()))
                    .endDate(DateTimeProvider.format(entity.getEndAt()))
                    .status(toStatus(entity.getStatus()))
                    .totalMembers(entity.getMembers().size());
            projectsSummaryResponse.addProjectsItem(summaryType);
        }
        return projectsSummaryResponse;
    }

    public static ProjectDetailsResponse toProjectDetailsResponse(ProjectEntity entity) {
        return new ProjectDetailsResponse().id(UUID.fromString(entity.getUuid()))
                .name(entity.getName()).description(entity.getDescription())
                .board(toBoard(entity.getBoard()))
                .owner(toOwnerDetails(entity.getOwner()))
                .status(toStatus(entity.getStatus()))
                .startDate(DateTimeProvider.format(entity.getStartAt()))
                .endDate(DateTimeProvider.format(entity.getEndAt()))
                .status(toStatus(entity.getStatus()))
                .totalMembers(entity.getMembers().size());
    }

    public static ProjectMembersSummaryResponse toProjectMembers(final SearchResult<ProjectMemberEntity> searchResult) {

        final ProjectMembersSummaryResponse response = new ProjectMembersSummaryResponse().totalCount(searchResult.getTotalCount());
        searchResult.getPayload().forEach(projectMemberEntity -> {
            response.addMembersItem(toProjectMember(projectMemberEntity.getMember()));
        });
        return response;

    }

    public static ProjectTasksSummaryResponse toProjectTasks(final SearchResult<TaskEntity> searchResult) {

        final ProjectTasksSummaryResponse response = new ProjectTasksSummaryResponse().totalCount(searchResult.getTotalCount());
        searchResult.getPayload().forEach(taskEntity -> {
            response.addTasksItem(toProjectTask(taskEntity));
        });
        return response;

    }

    private static ProjectBoardSummaryType toBoard(final BoardEntity boardEntity) {
        return new ProjectBoardSummaryType().id(UUID.fromString(boardEntity.getUuid())).name(boardEntity.getName());
    }

    private static ProjectOwnerType toOwner(final UserEntity owner) {
        return new ProjectOwnerType().id(UUID.fromString(owner.getUuid())).firstName(owner.getFirstName()).lastName(owner.getLastName());
    }

    private static ProjectStatusType toStatus(final int statusCode) {
        return ProjectStatusType.valueOf(ProjectStatus.get(statusCode).name());
    }

    private static ProjectOwnerDetailsType toOwnerDetails(final UserEntity owner) {
        return new ProjectOwnerDetailsType().id(UUID.fromString(owner.getUuid())).firstName(owner.getFirstName())
                .lastName(owner.getLastName()).emailAddress(owner.getEmail())
                .role(RoleTransformer.toRoleType(owner.getRole()));
    }

    private static ProjectMemberSummaryType toProjectMember(final UserEntity userEntity) {
        return new ProjectMemberSummaryType().id(UUID.fromString(userEntity.getUuid()))
                .firstName(userEntity.getFirstName()).lastName(userEntity.getLastName())
                .emailAddress(userEntity.getEmail()).status(toMemberStatus(userEntity.getStatus()))
                .role(RoleTransformer.toRoleType(userEntity.getRole()));
    }

    private static ProjectTaskSummaryType toProjectTask(final TaskEntity taskEntity) {
        return new ProjectTaskSummaryType().id(UUID.fromString(taskEntity.getUuid()))
                .name(taskEntity.getName())
                .owner(TaskTransformer.toOwner(taskEntity.getOwner().getMember()))
                .originalEffort(taskEntity.getOriginalEffort())
                .loggedEffort(taskEntity.getLoggedEffort())
                .remainingEffort(taskEntity.getRemainingEffort())
                .status(TaskTransformer.toStatus(taskEntity.getStatus()));
    }

    private static MemberStatusType toMemberStatus(final int statusCode) {
        return MemberStatusType.valueOf(UserStatus.get(statusCode).name());
    }

}
