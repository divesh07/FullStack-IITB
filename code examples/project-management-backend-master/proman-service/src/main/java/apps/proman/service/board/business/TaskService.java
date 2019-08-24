package apps.proman.service.board.business;

import java.util.Set;
import javax.validation.constraints.NotNull;

import apps.proman.service.board.entity.ProjectEntity;
import apps.proman.service.board.entity.ProjectMemberEntity;
import apps.proman.service.board.entity.TaskEntity;
import apps.proman.service.board.entity.TaskWatcherEntity;
import apps.proman.service.board.model.ProjectStatus;
import apps.proman.service.board.model.TaskStatus;
import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.common.model.SearchResult;

public interface TaskService {

    SearchResult<TaskEntity> findTasks(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull Integer page, @NotNull Integer limit);

    SearchResult<TaskEntity> findTasks(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull TaskStatus taskStatus, @NotNull Integer page, @NotNull Integer limit);

    TaskEntity findTask(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid) throws ApplicationException;

    TaskEntity createTask(@NotNull TaskEntity newTask) throws ApplicationException;

    void updateTask(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid, @NotNull TaskEntity updatedTask) throws ApplicationException;

    void deleteTask(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid) throws ApplicationException;

    void changeTaskOwner(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid, @NotNull String ownerUuid) throws ApplicationException;

    void changeTaskStatus(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid, @NotNull TaskStatus newTaskStatus) throws ApplicationException;

    void addEffort(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid, @NotNull Integer loggedEffort) throws ApplicationException ;

    void removeEffort(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid, @NotNull Integer loggedEffort) throws ApplicationException ;

    SearchResult<TaskWatcherEntity> getWatchers(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid) throws ApplicationException;

    void addWatchers(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid, @NotNull Set<String> watcherUuids) throws ApplicationException;

    void removeWatchers(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid, @NotNull Set<String> watcherUuids) throws ApplicationException;

}
