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
@Table(name = "PROJECT_MEMBERS", schema = SCHEMA)
@NamedQueries({
        @NamedQuery(name = ProjectMemberEntity.BY_PROJECT_AND_MEMBER, query = "select pm from ProjectMemberEntity pm where pm.project.uuid = :projectUuid and pm.member.uuid = :memberUuid")
})
public class ProjectMemberEntity extends ImmutableEntity implements Identifier<Integer>, Serializable {

    public static final String BY_PROJECT_AND_MEMBER = "ProjectMemberEntity.byProjectAndMember";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private ProjectEntity project;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private UserEntity member;

    @Override
    public Integer getId() {
        return id;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public UserEntity getMember() {
        return member;
    }

    public void setMember(UserEntity member) {
        this.member = member;
    }

}