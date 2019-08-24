package apps.proman.service.board.entity;

import static apps.proman.service.common.entity.Entity.SCHEMA;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
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
import apps.proman.service.user.entity.RoleEntity;
import apps.proman.service.user.entity.UserEntity;

@Entity
@Table(name = "PROJECTS", schema = SCHEMA)
@NamedQueries({
        @NamedQuery(name = ProjectEntity.COUNT_BY_ALL, query = "select count(p.id) from ProjectEntity p where p.board.uuid = :boardUuid"),
        @NamedQuery(name = ProjectEntity.BY_ALL, query = "select p from ProjectEntity p where p.board.uuid = :boardUuid"),
        @NamedQuery(name = ProjectEntity.BY_NAME, query = "select p from ProjectEntity p where p.name = :name"),
        @NamedQuery(name = ProjectEntity.COUNT_BY_STATUS, query = "select count(p.id) from ProjectEntity p  where p.board.uuid = :boardUuid and p.status = :status"),
        @NamedQuery(name = ProjectEntity.BY_STATUS, query = "select p from ProjectEntity p  where p.board.uuid = :boardUuid and p.status = :status"),
        @NamedQuery(name = ProjectEntity.BY_BOARD_AND_PROJECT, query = "select p from ProjectEntity p  where p.board.uuid = :boardUuid and p.uuid = :projectUuid")
})
public class ProjectEntity extends MutableEntity implements Identifier<Integer>, UniversalUniqueIdentifier<String>, Serializable {

    public static final String COUNT_BY_ALL = "ProjectEntity.countByAll";
    public static final String BY_ALL = "ProjectEntity.byAll";
    public static final String BY_NAME = "ProjectEntity.byName";
    public static final String COUNT_BY_STATUS = "ProjectEntity.countByStatus";
    public static final String BY_STATUS = "ProjectEntity.byStatus";
    public static final String BY_BOARD_AND_PROJECT = "ProjectEntity.byBoardAndProject";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID")
    @NotNull
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private BoardEntity board;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private UserEntity owner;

    @Column(name = "NAME")
    @NotNull
    @Size(max = 100)
    private String name;

    @Column(name = "DESCRIPTION")
    @Size(max = 500)
    private String description;

    @Column(name = "START_AT")
    private ZonedDateTime startAt;

    @Column(name = "END_AT")
    private ZonedDateTime endAt;

    @Column(name = "STATUS")
    @NotNull
    private Integer status;

    @OneToMany(mappedBy = "project")
    private List<ProjectMemberEntity> members;

    @OneToMany(mappedBy = "project")
    private List<TaskEntity> tasks;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    public BoardEntity getBoard() {
        return board;
    }

    public void setBoard(BoardEntity board) {
        this.board = board;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ProjectMemberEntity> getMembers() {
        return members;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
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
