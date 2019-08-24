package apps.proman.service.board.dao;

import javax.validation.constraints.NotNull;

import apps.proman.service.board.entity.ProjectEntity;
import apps.proman.service.board.entity.ProjectMemberEntity;
import apps.proman.service.board.model.ProjectStatus;
import apps.proman.service.common.dao.BaseDao;
import apps.proman.service.common.model.SearchResult;

public interface ProjectDao extends BaseDao<ProjectEntity> {

    SearchResult<ProjectEntity> find(@NotNull String boardUuid, @NotNull Integer page, @NotNull Integer limit);

    SearchResult<ProjectEntity> find(@NotNull String boardUuid, @NotNull ProjectStatus projectStatus, @NotNull Integer page, @NotNull Integer limit);

    ProjectEntity findByUUID(@NotNull String boardUuid, @NotNull String projectUuid);

    ProjectEntity findByName(@NotNull String projectName);

    ProjectMemberEntity findMember(@NotNull String projectUuid, @NotNull String memberUuid);

    ProjectMemberEntity addMember(@NotNull ProjectMemberEntity newProjectMemberEntity);

    void removeMember(@NotNull ProjectMemberEntity removeProjectMemberEntity);

}
