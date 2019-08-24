package apps.proman.service.board.entity;

import static apps.proman.service.common.entity.Entity.SCHEMA;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import apps.proman.service.common.entity.Identifier;
import apps.proman.service.common.entity.ImmutableEntity;
import apps.proman.service.user.entity.UserEntity;

@Entity
@Table(name = "TASK_WATCHERS", schema = SCHEMA)
@NamedQueries({
        @NamedQuery(name = TaskWatcherEntity.BY_TASK_AND_WATCHER, query = "select t from TaskWatcherEntity t where t.task.uuid = :taskUuid and t.watcher.uuid = :watcherUuid")
})
public class TaskWatcherEntity extends ImmutableEntity implements Identifier<Integer>, Serializable {

    public static final String BY_TASK_AND_WATCHER = "TaskWatcherEntity.byTaskAndWatcher";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "TASK_ID")
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "WATCHER_ID")
    private UserEntity watcher;

    @Override
    public Integer getId() {
        return id;
    }

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    public UserEntity getWatcher() {
        return watcher;
    }

    public void setWatcher(UserEntity watcher) {
        this.watcher = watcher;
    }

}