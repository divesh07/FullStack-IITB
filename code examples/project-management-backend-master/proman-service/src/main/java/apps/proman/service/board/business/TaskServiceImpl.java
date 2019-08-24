package apps.proman.service.board.business;

import static apps.proman.service.board.exception.TaskErrorCode.TSK_003;
import static apps.proman.service.board.exception.TaskErrorCode.TSK_004;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import apps.proman.service.board.dao.ProjectDao;
import apps.proman.service.board.dao.TaskDao;
import apps.proman.service.board.entity.ProjectMemberEntity;
import apps.proman.service.board.entity.TaskEntity;
import apps.proman.service.board.entity.TaskWatcherEntity;
import apps.proman.service.board.exception.ProjectErrorCode;
import apps.proman.service.board.model.TaskStatus;
import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.common.exception.EntityNotFoundException;
import apps.proman.service.common.model.SearchResult;
import apps.proman.service.user.dao.UserDao;
import apps.proman.service.user.entity.UserEntity;

@Service
public class TaskServiceImpl implements  TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private UserDao userDao;

    @Override
    public SearchResult<TaskEntity> findTasks(String boardUuid, String projectUuid, Integer page, Integer limit) {
        return taskDao.find(boardUuid, projectUuid, page, limit);
    }

    @Override
    public SearchResult<TaskEntity> findTasks(String boardUuid, String projectUuid, TaskStatus taskStatus, Integer page, Integer limit) {
        return taskDao.find(boardUuid, projectUuid, taskStatus, page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TaskEntity findTask(String boardUuid, String projectUuid, String taskUuid) throws ApplicationException {
        return findExistingTask(boardUuid, projectUuid, taskUuid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TaskEntity createTask(TaskEntity newTask) throws ApplicationException {

        if(newTask.getOriginalEffort() != null && newTask.getRemainingEffort() == null) {
            newTask.setRemainingEffort(newTask.getOriginalEffort());
        }
        newTask.setStatus(TaskStatus.OPEN.getCode());
        return taskDao.create(newTask);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateTask(String boardUuid, String projectUuid, String taskUuid, TaskEntity updatedTask) throws ApplicationException {

        final TaskEntity existingTask = findNonDeletedExistingTask(boardUuid, projectUuid, taskUuid);

        if (StringUtils.isNotEmpty(updatedTask.getName())) {
            existingTask.setName(updatedTask.getName());
        }
        if (StringUtils.isNotEmpty(updatedTask.getDescription())) {
            existingTask.setDescription(updatedTask.getDescription());
        }
        if (updatedTask.getOwner() != null) {
            existingTask.setOwner(updatedTask.getOwner());
        }
        if (updatedTask.getStartAt() != null) {
            existingTask.setStartAt(updatedTask.getStartAt());
        }
        if (updatedTask.getEndAt() != null) {
            existingTask.setEndAt(updatedTask.getEndAt());
        }
        if (updatedTask.getOriginalEffort() != null) {
            existingTask.setOriginalEffort(updatedTask.getOriginalEffort());
        }
        if (updatedTask.getLoggedEffort() != null) {
            existingTask.setLoggedEffort(updatedTask.getLoggedEffort());
        }
        if (updatedTask.getRemainingEffort() != null) {
            existingTask.setRemainingEffort(updatedTask.getRemainingEffort());
        }

        if(updatedTask.getOriginalEffort() != null && updatedTask.getRemainingEffort() == null) {
            existingTask.setRemainingEffort(updatedTask.getOriginalEffort());
        }

        taskDao.update(existingTask);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteTask(String boardUuid, String projectUuid, String taskUuid) throws ApplicationException {

        final TaskEntity existingTask = findNonDeletedExistingTask(boardUuid, projectUuid, taskUuid);
        existingTask.setStatus(TaskStatus.DELETED.getCode());
        taskDao.update(existingTask);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeTaskOwner(String boardUuid, String projectUuid, String taskUuid, String ownerUuid) throws ApplicationException {

        final TaskEntity existingTask = findNonDeletedExistingTask(boardUuid, projectUuid, taskUuid);
        if(!existingTask.getOwner().getMember().getUuid().equals(ownerUuid)) {
            final ProjectMemberEntity newOwner = projectDao.findMember(projectUuid, ownerUuid);
            if(newOwner == null) {
                throw new EntityNotFoundException(ProjectErrorCode.PRJ_005, ownerUuid, projectUuid);
            }
            existingTask.setOwner(newOwner);
            taskDao.update(existingTask);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeTaskStatus(String boardUuid, String projectUuid, String taskUuid, TaskStatus newTaskStatus) throws ApplicationException {

        final TaskEntity existingTask = findExistingTask(boardUuid, projectUuid, taskUuid);
        if (existingTask.getStatus() != newTaskStatus.getCode()) {
            existingTask.setStatus(newTaskStatus.getCode());
            taskDao.update(existingTask);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addEffort(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid, @NotNull Integer effortLogged) throws ApplicationException {

        final TaskEntity existingTask = findNonDeletedExistingTask(boardUuid, projectUuid, taskUuid);

        final Integer loggedEffort = existingTask.getLoggedEffort() == null ? 0 : existingTask.getLoggedEffort();
        existingTask.setLoggedEffort(loggedEffort + effortLogged);

        final Integer remainingEffort = existingTask.getRemainingEffort();
        if(remainingEffort != null && remainingEffort > 0) {
            existingTask.setRemainingEffort(remainingEffort - effortLogged);
        }

        taskDao.update(existingTask);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeEffort(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull String taskUuid, @NotNull Integer effortRemoved) throws ApplicationException {

        final TaskEntity existingTask = findNonDeletedExistingTask(boardUuid, projectUuid, taskUuid);

        final Integer loggedEffort = existingTask.getLoggedEffort();
        if(loggedEffort != null && loggedEffort > 0) {
            existingTask.setLoggedEffort(loggedEffort - effortRemoved);
        }

        final Integer remainingEffort = existingTask.getRemainingEffort();
        if(remainingEffort != null) {
            existingTask.setRemainingEffort(remainingEffort + effortRemoved);
        }

        taskDao.update(existingTask);
    }

    @Override
    public SearchResult<TaskWatcherEntity> getWatchers(String boardUuid, String projectUuid, String taskUuid) throws ApplicationException {

        final TaskEntity existingTask = findExistingTask(boardUuid, projectUuid, taskUuid);
        List<TaskWatcherEntity> taskWatchers = existingTask.getWatchers();
        return new SearchResult(taskWatchers.size(), taskWatchers);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addWatchers(String boardUuid, String projectUuid, String taskUuid, Set<String> watcherUuids) throws ApplicationException {

        final TaskEntity existingTask = findNonDeletedExistingTask(boardUuid, projectUuid, taskUuid);
        for (final String watcherUuid : watcherUuids) {
            final UserEntity existingWatcher = userDao.findByUUID(watcherUuid);
            if (existingWatcher != null && taskDao.findWatcher(taskUuid, watcherUuid) == null) {
                final TaskWatcherEntity taskWatcherEntity = new TaskWatcherEntity();
                taskWatcherEntity.setTask(existingTask);
                taskWatcherEntity.setWatcher(existingWatcher);
                taskDao.addWatcher(taskWatcherEntity);
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeWatchers(String boardUuid, String projectUuid, String taskUuid, Set<String> watcherUuids) throws ApplicationException {

        findNonDeletedExistingTask(boardUuid, projectUuid, taskUuid); //cannot modify state of deleted task
        for (final String watcherUuid : watcherUuids) {
            TaskWatcherEntity existingTaskWatcher = taskDao.findWatcher(taskUuid, watcherUuid);
            if (existingTaskWatcher != null) {
                taskDao.removeWatcher(existingTaskWatcher);
            }
        }

    }

    private TaskEntity findExistingTask(String boardUuid, String projectUuid, String taskUuid) throws ApplicationException {

        final TaskEntity existingTask = taskDao.findByUUID(boardUuid, projectUuid, taskUuid);
        if (existingTask == null) {
            throw new EntityNotFoundException(TSK_003, projectUuid, boardUuid);
        }
        return existingTask;
    }

    private TaskEntity findNonDeletedExistingTask(String boardUuid, String projectUuid, String taskUuid) throws ApplicationException {

        final TaskEntity existingTask = findExistingTask(boardUuid, projectUuid, taskUuid);
        if(TaskStatus.DELETED.getCode() == existingTask.getStatus()) {
            throw new ApplicationException(TSK_004, taskUuid);
        }
        return existingTask;
    }

}
