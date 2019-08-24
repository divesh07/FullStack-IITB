package apps.proman.service.board.dao;

import static apps.proman.service.board.entity.ProjectEntity.*;
import static apps.proman.service.board.entity.ProjectMemberEntity.BY_PROJECT_AND_MEMBER;

import java.util.List;
import javax.persistence.NoResultException;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Repository;

import apps.proman.service.board.entity.ProjectEntity;
import apps.proman.service.board.entity.ProjectMemberEntity;
import apps.proman.service.board.model.ProjectStatus;
import apps.proman.service.common.dao.BaseDaoImpl;
import apps.proman.service.common.model.SearchResult;

@Repository
public class ProjectDaoImpl extends BaseDaoImpl<ProjectEntity> implements ProjectDao {

    @Override
    public SearchResult<ProjectEntity> find(String boardUuid, Integer page, Integer limit) {

        final int totalCount = entityManager.createNamedQuery(COUNT_BY_ALL, Long.class)
                .setParameter("boardUuid", boardUuid)
                .getSingleResult().intValue();
        final List<ProjectEntity> payload = entityManager.createNamedQuery(BY_ALL, ProjectEntity.class)
                .setParameter("boardUuid", boardUuid)
                .setFirstResult(getOffset(page, limit)).setMaxResults(limit).getResultList();
        return new SearchResult(totalCount, payload);
    }

    @Override
    public SearchResult<ProjectEntity> find(String boardUuid,ProjectStatus projectStatus, Integer page, Integer limit) {

        final int totalCount = entityManager.createNamedQuery(COUNT_BY_STATUS, Long.class)
                .setParameter("boardUuid", boardUuid)
                .setParameter("status", projectStatus.getCode())
                .getSingleResult().intValue();
        final List<ProjectEntity> payload = entityManager.createNamedQuery(BY_STATUS, ProjectEntity.class)
                .setParameter("boardUuid", boardUuid)
                .setParameter("status", projectStatus.getCode())
                .setFirstResult(getOffset(page, limit)).setMaxResults(limit).getResultList();
        return new SearchResult(totalCount, payload);
    }

    @Override
    public ProjectEntity findByUUID(String boardUuid, String projectUuid) {
        try {
            return entityManager.createNamedQuery(BY_BOARD_AND_PROJECT, ProjectEntity.class)
                    .setParameter("boardUuid", boardUuid)
                    .setParameter("projectUuid", projectUuid)
                    .getSingleResult();
        } catch (NoResultException exc) {
            return null;
        }
    }

    @Override
    public ProjectEntity findByName(String projectName) {

        try {
            return entityManager.createNamedQuery(BY_NAME, ProjectEntity.class)
                    .setParameter("name", projectName).getSingleResult();
        } catch (NoResultException exc) {
            return null;
        }
    }

    @Override
    public ProjectMemberEntity findMember(String projectUuid, String memberUuid) {

        try {
            return entityManager.createNamedQuery(BY_PROJECT_AND_MEMBER, ProjectMemberEntity.class)
                    .setParameter("projectUuid", projectUuid)
                    .setParameter("memberUuid", memberUuid)
                    .getSingleResult();
        } catch (NoResultException exc) {
            return null;
        }
    }

    @Override
    public ProjectMemberEntity addMember(ProjectMemberEntity newProjectMemberEntity) {
        entityManager.persist(newProjectMemberEntity);
        return newProjectMemberEntity;
    }

    @Override
    public void removeMember(ProjectMemberEntity removeProjectMemberEntity) {
        entityManager.remove(removeProjectMemberEntity);
    }

}
