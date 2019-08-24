/*
 * Copyright 2018-2019, https://beingtechie.io.
 *
 * File: AuthTokenServiceImpl.java
 * Date: May 5, 2018
 * Author: Thribhuvan Krishnamurthy
 */
package apps.proman.service.user.business;

import static apps.proman.service.user.exception.UserErrorCode.USR_005;
import static apps.proman.service.user.exception.UserErrorCode.USR_006;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import apps.proman.service.common.data.DateTimeProvider;
import apps.proman.service.common.exception.AuthorizationFailedException;
import apps.proman.service.user.dao.UserAuthDao;
import apps.proman.service.user.dao.UserDao;
import apps.proman.service.user.entity.UserAuthTokenEntity;
import apps.proman.service.user.entity.UserEntity;
import apps.proman.service.user.provider.token.JwtTokenProvider;

/**
 * Implementation of {@link AuthTokenService}.
 */
@Service
public class AuthTokenServiceImpl implements AuthTokenService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserAuthDao userAuthDao;


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public UserAuthTokenEntity issueToken(final UserEntity userEntity) {

        final ZonedDateTime now = DateTimeProvider.currentProgramTime();

        final UserAuthTokenEntity userAuthToken = userAuthDao.findActiveTokenByUser(userEntity.getId(), now);
        final UserAuthTokenVerifier tokenVerifier = new UserAuthTokenVerifier(userAuthToken);
        if(tokenVerifier.isActive()) {
            return userAuthToken;
        }

        final JwtTokenProvider tokenProvider = new JwtTokenProvider(userEntity.getPassword());

        final ZonedDateTime expiresAt = now.plusHours(8);

        final String authToken = tokenProvider.generateToken(userEntity.getUuid(), now, expiresAt);

        final UserAuthTokenEntity authTokenEntity = new UserAuthTokenEntity();
        authTokenEntity.setUser(userEntity);
        authTokenEntity.setAccessToken(authToken);
        authTokenEntity.setLoginAt(now);
        authTokenEntity.setExpiresAt(expiresAt);
        userAuthDao.create(authTokenEntity);

        userEntity.setLastLoginAt(now);
        userDao.update(userEntity);

        return authTokenEntity;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void invalidateToken(final String accessToken) throws AuthorizationFailedException {

        final UserAuthTokenEntity userAuthToken = userAuthDao.findToken(accessToken);
        final UserAuthTokenVerifier tokenVerifier = new UserAuthTokenVerifier(userAuthToken);
        if(tokenVerifier.isNotFound()) {
            throw new AuthorizationFailedException(USR_005);
        }
        if(tokenVerifier.hasExpired()) {
            throw new AuthorizationFailedException(USR_006);
        }

        userAuthToken.setLogoutAt(ZonedDateTime.now());
        userAuthDao.update(userAuthToken);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void validateToken(@NotNull String accessToken) throws AuthorizationFailedException {
        final UserAuthTokenEntity userAuthToken = userAuthDao.findToken(accessToken);
        final UserAuthTokenVerifier tokenVerifier = new UserAuthTokenVerifier(userAuthToken);
        if(tokenVerifier.isNotFound() || tokenVerifier.hasLoggedOut()) {
            throw new AuthorizationFailedException(USR_005);
        }
        if(tokenVerifier.hasExpired()) {
            throw new AuthorizationFailedException(USR_006);
        }
    }

}