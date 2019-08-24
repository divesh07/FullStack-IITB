package apps.proman.service.user.business;

import static apps.proman.service.user.exception.UserErrorCode.USR_011;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.common.exception.EntityNotFoundException;
import apps.proman.service.user.dao.RoleDao;
import apps.proman.service.user.entity.RoleEntity;

@Service
public class RoleServiceImpl implements  RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public RoleEntity findRoleByUuid(@NotNull Integer roleUuid) throws ApplicationException {

        RoleEntity roleEntity = roleDao.findByUUID(roleUuid);
        if(roleEntity == null) {
            throw new EntityNotFoundException(USR_011, roleUuid);
        }
        return roleEntity;
    }
}
