/*
 * Copyright 2018-2019, https://beingtechie.io.
 *
 * File: UserAuthDao.java
 * Date: May 5, 2018
 * Author: Thribhuvan Krishnamurthy
 */
package apps.proman.service.user.dao;

import java.time.ZonedDateTime;
import javax.validation.constraints.NotNull;

import apps.proman.service.common.dao.BaseDao;
import apps.proman.service.user.entity.UserAuthTokenEntity;

/**
 * DAO interface for {@link UserAuthTokenEntity}.
 */
public interface UserAuthDao extends BaseDao<UserAuthTokenEntity> {

    UserAuthTokenEntity findToken(@NotNull String accessToken);

    UserAuthTokenEntity findActiveTokenByUser(@NotNull long userId, @NotNull ZonedDateTime currentAt);

}