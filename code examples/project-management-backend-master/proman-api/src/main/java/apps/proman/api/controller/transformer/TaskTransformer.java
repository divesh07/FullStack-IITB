package apps.proman.api.controller.transformer;

import java.util.List;
import java.util.UUID;

import apps.proman.api.model.CreateProjectTaskRequest;
import apps.proman.api.model.CreateProjectTaskResponse;
import apps.proman.api.model.ProjectTaskDetailsResponse;
import apps.proman.api.model.ProjectTaskSummaryType;
import apps.proman.api.model.ProjectTasksSummaryResponse;
import apps.proman.api.model.TaskOwnerDetailsType;
import apps.proman.api.model.TaskOwnerType;
import apps.proman.api.model.TaskProjectSummaryType;
import apps.proman.api.model.TaskStatusType;
import apps.proman.api.model.TaskWatcherType;
import apps.proman.api.model.TaskWatchersType;
import apps.proman.api.model.UpdateProjectTaskRequest;
import apps.proman.service.board.entity.ProjectEntity;
import apps.proman.service.board.entity.TaskEntity;
import apps.proman.service.board.entity.TaskWatcherEntity;
import apps.proman.service.board.model.TaskStatus;
import apps.proman.service.common.data.DateTimeProvider;
import apps.proman.service.common.model.SearchResult;
import apps.proman.service.user.entity.UserEntity;

public final class TaskTransformer {

    private TaskTransformer() {
    }

    public static TaskEntity toEntity(final CreateProjectTaskRequest boardProjectRequest) {
        TaskEntity projectEntity = new TaskEntity();
        projectEntity.setName(boardProjectRequest.getName());
        projectEntity.setDescription(boardProjectRequest.getDescription());
        if(boardProjectRequest.getStartDate() != null) {
            projectEntity.setStartAt(DateTimeProvider.parse(boardProjectRequest.getStartDate()));
        }
        if(boardProjectRequest.getEndDate() != null) {
            projectEntity.setEndAt(DateTimeProvider.parse(boardProjectRequest.getEndDate()));
        }
        projectEntity.setOriginalEffort(boardProjectRequest.getOriginalEffort());
        return projectEntity;
    }

    public static TaskEntity toEntity(final UpdateProjectTaskRequest updateProjectTaskRequest) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setName(updateProjectTaskRequest.getName());
        taskEntity.setDescription(updateProjectTaskRequest.getDescription());
        if(updateProjectTaskRequest.getStartDate() != null) {
            taskEntity.setStartAt(DateTimeProvider.parse(updateProjectTaskRequest.getStartDate()));
        }
        if(updateProjectTaskRequest.getEndDate() != null) {
            taskEntity.setEndAt(DateTimeProvider.parse(updateProjectTaskRequest.getEndDate()));
        }
        taskEntity.setOriginalEffort(updateProjectTaskRequest.getOriginalEffort());
        return taskEntity;
    }

    public static CreateProjectTaskResponse toResponse(final TaskEntity projectEntity) {
        return new CreateProjectTaskResponse().id(UUID.fromString(projectEntity.getUuid()))
                .status(toStatus(projectEntity.getStatus()));
    }


    public static ProjectTasksSummaryResponse toTasksSummaryResponse(final int page, final int limit, final SearchResult<TaskEntity> searchResult) {

        ProjectTasksSummaryResponse projectsSummaryResponse = new ProjectTasksSummaryResponse().totalCount(searchResult.getTotalCount()).page(page).limit(limit);

        for (TaskEntity entity : searchResult.getPayload()) {
            ProjectTaskSummaryType summaryType = new ProjectTaskSummaryType().id(UUID.fromString(entity.getUuid()))
                    .name(entity.getName()).description(entity.getDescription())
                    .project(toProject(entity.getProject()))
                    .owner(toOwner(entity.getOwner().getMember()))
                    .status(toStatus(entity.getStatus()))
                    .originalEffort(entity.getOriginalEffort())
                    .loggedEffort(entity.getLoggedEffort())
                    .remainingEffort(entity.getRemainingEffort());
            projectsSummaryResponse.addTasksItem(summaryType);
        }
        return projectsSummaryResponse;
    }

    public static ProjectTaskDetailsResponse toTaskDetailsResponse(TaskEntity entity) {

        final ProjectTaskDetailsResponse taskDetailsResponse = new ProjectTaskDetailsResponse().id(UUID.fromString(entity.getUuid()))
                .name(entity.getName()).description(entity.getDescription())
                .project(toProject(entity.getProject()))
                .owner(toOwnerDetails(entity.getOwner().getMember()))
                .status(toStatus(entity.getStatus()))
                .status(toStatus(entity.getStatus()))
                .originalEffort(entity.getOriginalEffort())
                .loggedEffort(entity.getLoggedEffort())
                .remainingEffort(entity.getRemainingEffort())
                .watchers(watchers(entity.getWatchers()));
        if(entity.getStartAt() != null) {
            taskDetailsResponse.startDate(DateTimeProvider.format(entity.getStartAt()));
        }
        if(entity.getEndAt() != null) {
            taskDetailsResponse.endDate(DateTimeProvider.format(entity.getEndAt()));
        }

        return taskDetailsResponse;
    }

    private static TaskProjectSummaryType toProject(final ProjectEntity projectEntity) {
        return new TaskProjectSummaryType().id(UUID.fromString(projectEntity.getUuid())).name(projectEntity.getName());
    }

    public static TaskOwnerType toOwner(final UserEntity owner) {
        return new TaskOwnerType().id(UUID.fromString(owner.getUuid())).firstName(owner.getFirstName()).lastName(owner.getLastName());
    }

    public static TaskStatusType toStatus(final int statusCode) {
        return TaskStatusType.valueOf(TaskStatus.get(statusCode).name());
    }

    private static TaskOwnerDetailsType toOwnerDetails(final UserEntity owner) {
        return new TaskOwnerDetailsType().id(UUID.fromString(owner.getUuid())).firstName(owner.getFirstName())
                .lastName(owner.getLastName()).emailAddress(owner.getEmail())
                .role(RoleTransformer.toRoleType(owner.getRole()));
    }

    private static TaskWatchersType watchers(final List<TaskWatcherEntity> watchers) {
        TaskWatchersType taskWatchersType = new TaskWatchersType();
        watchers.forEach(taskWatcherEntity -> {
            UserEntity watcher = taskWatcherEntity.getWatcher();
            taskWatchersType.add(new TaskWatcherType().id(UUID.fromString(watcher.getUuid()))
                    .firstName(watcher.getFirstName()).lastName(watcher.getLastName()));
        });
        return taskWatchersType;
    }

}
