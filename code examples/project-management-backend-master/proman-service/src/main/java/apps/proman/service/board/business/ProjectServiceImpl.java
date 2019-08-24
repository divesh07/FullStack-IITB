package apps.proman.service.board.business;

import static apps.proman.service.board.exception.ProjectErrorCode.*;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import apps.proman.service.board.dao.ProjectDao;
import apps.proman.service.board.entity.ProjectEntity;
import apps.proman.service.board.entity.ProjectMemberEntity;
import apps.proman.service.board.exception.ProjectErrorCode;
import apps.proman.service.board.model.ProjectStatus;
import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.common.exception.EntityNotFoundException;
import apps.proman.service.common.model.SearchResult;
import apps.proman.service.user.dao.UserDao;
import apps.proman.service.user.entity.UserEntity;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private UserDao userDao;

    @Override
    public SearchResult<ProjectEntity> findProjects(String boardUuid, Integer page, Integer limit) {
        return projectDao.find(boardUuid, page, limit);
    }

    @Override
    public SearchResult<ProjectEntity> findProjects(String boardUuid, ProjectStatus projectStatus, Integer page, Integer limit) {
        return projectDao.find(boardUuid, projectStatus, page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ProjectEntity findProject(String boardUuid, String projectUuid) throws ApplicationException {
        return findExistingProject(boardUuid, projectUuid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ProjectEntity createProject(ProjectEntity newProject) throws ApplicationException {

        if (projectDao.findByName(newProject.getName()) != null) {
            throw new ApplicationException(PRJ_002, newProject.getName());
        }

        newProject.setStatus(ProjectStatus.OPEN.getCode());
        return projectDao.create(newProject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateProject(String boardUuid, String projectUuid, ProjectEntity updatedProject) throws ApplicationException {

        final ProjectEntity existingProject = findNonDeletedExistingProject(boardUuid, projectUuid);

        if (StringUtils.isNotEmpty(updatedProject.getName())) {
            if (!existingProject.getName().equalsIgnoreCase(updatedProject.getName())
                    && projectDao.findByName(updatedProject.getName()) != null) {
                throw new ApplicationException(PRJ_002, updatedProject.getName());
            }
            existingProject.setName(updatedProject.getName());
        }

        if (StringUtils.isNotEmpty(updatedProject.getDescription())) {
            existingProject.setDescription(updatedProject.getDescription());
        }
        if (updatedProject.getOwner() != null) {
            existingProject.setOwner(updatedProject.getOwner());
        }
        if (updatedProject.getStartAt() != null) {
            existingProject.setStartAt(updatedProject.getStartAt());
        }
        if (updatedProject.getEndAt() != null) {
            existingProject.setEndAt(updatedProject.getEndAt());
        }

        projectDao.update(existingProject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteProject(String boardUuid, String projectUuid) throws ApplicationException {

        final ProjectEntity existingProject = findNonDeletedExistingProject(boardUuid, projectUuid);
        existingProject.setStatus(ProjectStatus.DELETED.getCode());
        projectDao.update(existingProject);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeProjectStatus(String boardUuid, String projectUuid, ProjectStatus newProjectStatus) throws ApplicationException {

        final ProjectEntity existingProject = findExistingProject(boardUuid, projectUuid);
        if (existingProject == null) {
            throw new EntityNotFoundException(PRJ_004, projectUuid, boardUuid);
        }

        if (existingProject.getStatus() != newProjectStatus.getCode()) {
            existingProject.setStatus(newProjectStatus.getCode());
            projectDao.update(existingProject);
        }

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SearchResult<ProjectMemberEntity> getProjectMembers(String boardUuid, String projectUuid) throws ApplicationException {
        final ProjectEntity existingProject = projectDao.findByUUID(boardUuid, projectUuid);
        if (existingProject == null) {
            throw new EntityNotFoundException(PRJ_004, projectUuid, boardUuid);
        }

        final List<ProjectMemberEntity> projectMembers = existingProject.getMembers();
        return new SearchResult(projectMembers.size(), projectMembers);
    }

    @Override
    public ProjectMemberEntity findMember(String projectUuid, String memberUuid) throws ApplicationException {

        final ProjectMemberEntity projectMember = projectDao.findMember(projectUuid, memberUuid);
        if (projectMember == null) {
            throw new EntityNotFoundException(ProjectErrorCode.PRJ_005, memberUuid, projectUuid);
        }
        return projectMember;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addMembers(String boardUuid, String projectUuid, Set<String> memberUuids) throws ApplicationException {

        final ProjectEntity existingProject = findNonDeletedExistingProject(boardUuid, projectUuid);

        for (final String memberUuid : memberUuids) {
            final UserEntity existingMember = userDao.findByUUID(memberUuid);
            if (existingMember != null && projectDao.findMember(projectUuid, memberUuid) == null) {
                final ProjectMemberEntity projectMemberEntity = new ProjectMemberEntity();
                projectMemberEntity.setProject(existingProject);
                projectMemberEntity.setMember(existingMember);
                projectDao.addMember(projectMemberEntity);
            }
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeMembers(String boardUuid, String projectUuid, Set<String> memberUuids) throws ApplicationException {

        findNonDeletedExistingProject(boardUuid, projectUuid); //cannot modify state of deleted project

        for (final String memberUuid : memberUuids) {
            ProjectMemberEntity existingProjectMember = projectDao.findMember(projectUuid, memberUuid);
            if (existingProjectMember != null) {
                projectDao.removeMember(existingProjectMember);
            }
        }
    }

    private ProjectEntity findExistingProject(String boardUuid, String projectUuid) throws ApplicationException {

        final ProjectEntity existingProject = projectDao.findByUUID(boardUuid, projectUuid);
        if (existingProject == null) {
            throw new EntityNotFoundException(PRJ_004, projectUuid, boardUuid);
        }

        return existingProject;
    }

    private ProjectEntity findNonDeletedExistingProject(String boardUuid, String projectUuid) throws ApplicationException {

        final ProjectEntity existingProject = findExistingProject(boardUuid, projectUuid);
        if (ProjectStatus.DELETED.getCode() == existingProject.getStatus()) {
            throw new ApplicationException(PRJ_007, projectUuid);
        }
        return existingProject;
    }

}
