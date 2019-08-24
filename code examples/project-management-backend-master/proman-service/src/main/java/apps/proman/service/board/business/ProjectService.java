package apps.proman.service.board.business;

import java.util.Set;
import javax.validation.constraints.NotNull;

import apps.proman.service.board.entity.ProjectEntity;
import apps.proman.service.board.entity.ProjectMemberEntity;
import apps.proman.service.board.model.ProjectStatus;
import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.common.model.SearchResult;

public interface ProjectService {

    SearchResult<ProjectEntity> findProjects(@NotNull String boardUuid, @NotNull Integer page, @NotNull Integer limit);

    SearchResult<ProjectEntity> findProjects(@NotNull String boardUuid, @NotNull ProjectStatus projectStatus, @NotNull Integer page, @NotNull Integer limit);

    ProjectEntity findProject(@NotNull String boardUuid, @NotNull String projectUuid) throws ApplicationException;

    ProjectEntity createProject(@NotNull ProjectEntity newProject) throws ApplicationException;

    void updateProject(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull ProjectEntity updatedProject) throws ApplicationException;

    void deleteProject(@NotNull String boardUuid, @NotNull String projectUuid) throws ApplicationException;

    void changeProjectStatus(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull ProjectStatus newProjectStatus) throws ApplicationException;

    SearchResult<ProjectMemberEntity> getProjectMembers(@NotNull String boardUuid, @NotNull String projectUuid) throws ApplicationException;

    ProjectMemberEntity findMember(@NotNull String projectUuid, @NotNull String memberUuid) throws ApplicationException ;

    void addMembers(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull Set<String> memberUuids) throws ApplicationException;

    void removeMembers(@NotNull String boardUuid, @NotNull String projectUuid, @NotNull Set<String> memberUuids) throws ApplicationException;

}
