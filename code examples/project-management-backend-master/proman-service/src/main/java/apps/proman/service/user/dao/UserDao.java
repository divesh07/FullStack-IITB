/*
 * Copyright 2018-2019, https://beingtechie.io.
 *
 * File: UserDao.java
 * Date: May 5, 2018
 * Author: Thribhuvan Krishnamurthy
 */
package apps.proman.service.user.dao;

import javax.validation.constraints.NotNull;

import apps.proman.service.common.dao.BaseDao;
import apps.proman.service.user.entity.UserEntity;
import apps.proman.service.common.model.SearchResult;
import apps.proman.service.user.model.UserStatus;

/**
 * DAO abstraction for {@link UserEntity}.
 */
public interface UserDao extends BaseDao<UserEntity> {

    UserEntity findByEmail(@NotNull String email);

    SearchResult<UserEntity> findUsers(UserStatus userStatus, int offset, int limit);

    SearchResult<UserEntity> findUsers(int offset, int limit);

}