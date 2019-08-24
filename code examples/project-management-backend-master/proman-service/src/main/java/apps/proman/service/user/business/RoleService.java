package apps.proman.service.user.business;

import javax.validation.constraints.NotNull;

import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.user.entity.RoleEntity;

public interface RoleService {

    RoleEntity findRoleByUuid(@NotNull Integer roleUuid) throws ApplicationException;

}