/*
 * Copyright 2018-2019, https://beingtechie.io.
 *
 * File: AuthTokenService.java
 * Date: May 5, 2018
 * Author: Thribhuvan Krishnamurthy
 */
package apps.proman.service.user.business;

import javax.validation.constraints.NotNull;

import apps.proman.service.common.exception.AuthorizationFailedException;
import apps.proman.service.user.entity.UserAuthTokenEntity;
import apps.proman.service.user.entity.UserEntity;

/**
 * Interface for user authentication related services.
 */
public interface AuthTokenService {

    UserAuthTokenEntity issueToken(@NotNull UserEntity userEntity) throws AuthorizationFailedException;

    void invalidateToken(@NotNull String accessToken) throws AuthorizationFailedException;

    void validateToken(@NotNull String accessToken) throws AuthorizationFailedException;

}