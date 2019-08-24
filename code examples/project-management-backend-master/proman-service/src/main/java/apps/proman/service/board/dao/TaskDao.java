package apps.proman.service.board.dao;

import javax.validation.constraints.NotNull;

import apps.proman.service.board.business.TaskService;
import apps.proman.service.board.entity.ProjectEntity;
import apps.proman.service.board.entity.ProjectMemberEntity;
import apps.proman.service.board.entity.TaskEntity;
import apps.proman.service.board.entity.TaskWatcherEntity;
import apps.proman.service.board.model.ProjectStatus;
import apps.proman.service.board.model.TaskStatus;
import apps.proman.service.common.dao.BaseDao;
import apps.proman.service.common.model.SearchResult;

public interface TaskDao extends BaseDao<TaskEntity> {

    SearchResult<TaskEntity> find(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull Integer page, @NotNull Integer limit);

    SearchResult<TaskEntity> find(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull TaskStatus taskStatus, @NotNull Integer page, @NotNull Integer limit);

    TaskEntity findByUUID(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid);

    TaskWatcherEntity findWatcher(@NotNull String taskUuid, @NotNull String watcherUuid);

    TaskWatcherEntity addWatcher(@NotNull TaskWatcherEntity newWatcherEntity);

    void removeWatcher(@NotNull TaskWatcherEntity removeWatcherEntity);

}
