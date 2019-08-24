package apps.proman.service.board.dao;


import static apps.proman.service.board.entity.TaskEntity.*;
import static apps.proman.service.board.entity.TaskWatcherEntity.BY_TASK_AND_WATCHER;

import java.util.List;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import apps.proman.service.board.entity.TaskEntity;
import apps.proman.service.board.entity.TaskWatcherEntity;
import apps.proman.service.board.model.TaskStatus;
import apps.proman.service.common.dao.BaseDaoImpl;
import apps.proman.service.common.model.SearchResult;

@Repository
public class TaskDaoImpl extends BaseDaoImpl<TaskEntity> implements TaskDao {

    @Override
    public SearchResult<TaskEntity> find(String boardUuid, String projectUuid, Integer page, Integer limit) {

        final int totalCount = entityManager.createNamedQuery(COUNT_BY_ALL, Long.class)
                .setParameter("boardUuid", boardUuid)
                .setParameter("projectUuid", projectUuid)
                .getSingleResult().intValue();
        final List<TaskEntity> payload = entityManager.createNamedQuery(BY_ALL, TaskEntity.class)
                .setParameter("boardUuid", boardUuid)
                .setParameter("projectUuid", projectUuid)
                .setFirstResult(getOffset(page, limit)).setMaxResults(limit).getResultList();
        return new SearchResult(totalCount, payload);
    }

    @Override
    public SearchResult<TaskEntity> find(String boardUuid, String projectUuid, TaskStatus taskStatus, Integer page, Integer limit) {

        final int totalCount = entityManager.createNamedQuery(COUNT_BY_STATUS, Long.class)
                .setParameter("boardUuid", boardUuid)
                .setParameter("projectUuid", projectUuid)
                .setParameter("status", taskStatus.getCode())
                .getSingleResult().intValue();
        final List<TaskEntity> payload = entityManager.createNamedQuery(BY_STATUS, TaskEntity.class)
                .setParameter("boardUuid", boardUuid)
                .setParameter("projectUuid", projectUuid)
                .setParameter("status", taskStatus.getCode())
                .setFirstResult(getOffset(page, limit)).setMaxResults(limit).getResultList();
        return new SearchResult(totalCount, payload);
    }

    @Override
    public TaskEntity findByUUID(String boardUuid, String projectUuid, String taskUuid) {
        try {
            return entityManager.createNamedQuery(BY_BOARD_AND_PROJECT_AND_TASK, TaskEntity.class)
                    .setParameter("boardUuid", boardUuid)
                    .setParameter("projectUuid", projectUuid)
                    .setParameter("taskUuid", taskUuid)
                    .getSingleResult();
        } catch (NoResultException exc) {
            return null;
        }
    }

    @Override
    public TaskWatcherEntity findWatcher(String taskUuid, String watcherUuid) {

        try {
            return entityManager.createNamedQuery(BY_TASK_AND_WATCHER, TaskWatcherEntity.class)
                    .setParameter("taskUuid", taskUuid)
                    .setParameter("watcherUuid", watcherUuid)
                    .getSingleResult();
        } catch (NoResultException exc) {
            return null;
        }
    }

    @Override
    public TaskWatcherEntity addWatcher(TaskWatcherEntity newWatcherEntity) {
        entityManager.persist(newWatcherEntity);
        return newWatcherEntity;
    }

    @Override
    public void removeWatcher(TaskWatcherEntity removeWatcherEntity) {
        entityManager.remove(removeWatcherEntity);
    }

}
