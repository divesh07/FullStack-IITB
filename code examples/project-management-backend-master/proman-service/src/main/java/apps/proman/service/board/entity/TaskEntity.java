package apps.proman.service.board.entity;

import static apps.proman.service.common.entity.Entity.SCHEMA;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import apps.proman.service.common.entity.Identifier;
import apps.proman.service.common.entity.MutableEntity;
import apps.proman.service.common.entity.UniversalUniqueIdentifier;
import apps.proman.service.common.entity.ext.EntityEqualsBuilder;
import apps.proman.service.common.entity.ext.EntityHashCodeBuilder;

@Entity
@Table(name = "TASKS", schema = SCHEMA)
@NamedQueries({
        @NamedQuery(name = TaskEntity.COUNT_BY_ALL, query = "select count(t.id) from TaskEntity t where t.project.board.uuid = :boardUuid and t.project.uuid = :projectUuid"),
        @NamedQuery(name = TaskEntity.BY_ALL, query = "select t from TaskEntity t where t.project.board.uuid = :boardUuid and t.project.uuid = :projectUuid"),
        @NamedQuery(name = TaskEntity.COUNT_BY_STATUS, query = "select count(t.id) from TaskEntity t where t.project.board.uuid = :boardUuid and t.project.uuid = :projectUuid and t.status = :status"),
        @NamedQuery(name = TaskEntity.BY_STATUS, query = "select t from TaskEntity t where t.project.board.uuid = :boardUuid and t.project.uuid = :projectUuid and t.status = :status"),
        @NamedQuery(name = TaskEntity.BY_BOARD_AND_PROJECT_AND_TASK, query = "select t from TaskEntity t where t.project.board.uuid = :boardUuid and t.project.uuid = :projectUuid and t.uuid = :taskUuid")
})
public class TaskEntity extends MutableEntity implements Identifier<Integer>, UniversalUniqueIdentifier<String>, Serializable {

    public static final String COUNT_BY_ALL = "TaskEntity.countByAll";
    public static final String BY_ALL = "TaskEntity.byAll";
    public static final String COUNT_BY_STATUS = "TaskEntity.countByStatus";
    public static final String BY_STATUS = "TaskEntity.byStatus";
    public static final String BY_BOARD_AND_PROJECT_AND_TASK = "TaskEntity.byBoardAndProjectAndTask";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID")
    @NotNull
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "PROJECT_MEMBER_ID")
    private ProjectMemberEntity owner;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private ProjectEntity project;

    @Column(name = "NAME")
    @NotNull
    @Size(max = 300)
    private String name;

    @Column(name = "DESCRIPTION")
    @Size(max = 2000)
    private String description;

    @Column(name = "START_AT")
    private ZonedDateTime startAt;

    @Column(name = "END_AT")
    private ZonedDateTime endAt;

    @Column(name = "ORIGINAL_EFFORT")
    private Integer originalEffort;

    @Column(name = "LOGGED_EFFORT")
    private Integer loggedEffort;

    @Column(name = "REMAINING_EFFORT")
    private Integer remainingEffort;

    @Column(name = "STATUS")
    @NotNull
    private Integer status;

    @OneToMany(mappedBy = "task")
    private List<TaskWatcherEntity> watchers;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    public ProjectMemberEntity getOwner() {
        return owner;
    }

    public void setOwner(ProjectMemberEntity owner) {
        this.owner = owner;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(ZonedDateTime startAt) {
        this.startAt = startAt;
    }

    public ZonedDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(ZonedDateTime endAt) {
        this.endAt = endAt;
    }

    public Integer getOriginalEffort() {
        return originalEffort;
    }

    public void setOriginalEffort(Integer originalEffort) {
        this.originalEffort = originalEffort;
    }

    public Integer getLoggedEffort() {
        return loggedEffort;
    }

    public void setLoggedEffort(Integer loggedEffort) {
        this.loggedEffort = loggedEffort;
    }

    public Integer getRemainingEffort() {
        return remainingEffort;
    }

    public void setRemainingEffort(Integer remainingEffort) {
        this.remainingEffort = remainingEffort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<TaskWatcherEntity> getWatchers() {
        return watchers;
    }

    @Override
    public boolean equals(Object obj) {
        return new EntityEqualsBuilder<Integer>().equalsById(this, obj);
    }

    @Override
    public int hashCode() {
        return new EntityHashCodeBuilder<Integer>().hashCodeById(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @PrePersist
    public void prePersist() {
        this.uuid = UUID.randomUUID().toString();
        super.prePersist();
    }
}
