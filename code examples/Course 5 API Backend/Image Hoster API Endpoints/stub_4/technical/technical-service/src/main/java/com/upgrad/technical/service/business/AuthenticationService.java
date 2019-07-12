package com.upgrad.technical.service.business;


import com.upgrad.technical.service.dao.UserDao;
import com.upgrad.technical.service.entity.UserAuthTokenEntity;
import com.upgrad.technical.service.entity.UserEntity;
import com.upgrad.technical.service.exception.AuthenticationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
public class AuthenticationService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordCryptographyProvider CryptographyProvider;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserAuthTokenEntity authenticate(final String username ,final String password) throws AuthenticationFailedException {
        UserEntity userEntity = userDao.getUserByEmail(username);
        if(userEntity == null) {
            //userEntity = null means that getUserByEmail() method did not return any object, which means that user with given email is not present in "users" table
            //throw "AuthenticationFailedException", AuthenticationFailedException is user defined exception and has been implemented
            //Note that the AuthenticationFailedException constructor requires two strings as an argument
            //First string is an Exception code - You can create your own code desired for this exception(e.g. ATH-001)
            //Second string is an Exception message - You can create any user friendly message which indicates that user with given email is not found(User with email not found)
            //Write code here//
            throw new AuthenticationFailedException("ATH-001", "User with email not found");
        }

        final String encryptedPassword = CryptographyProvider.encrypt(password,userEntity.getSalt());
        if(encryptedPassword.equals(userEntity.getPassword())) {
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(encryptedPassword);
            UserAuthTokenEntity userAuthTokenEntity = new UserAuthTokenEntity();
            userAuthTokenEntity.setUser(userEntity);
            final ZonedDateTime now=ZonedDateTime.now();
            final ZonedDateTime expiresAt=now.plusHours(8);

            userAuthTokenEntity.setAccessToken(jwtTokenProvider.generateToken(userEntity.getUuid(),now,expiresAt));

            userAuthTokenEntity.setLoginAt(now);
            userAuthTokenEntity.setExpiresAt(expiresAt);

            userDao.createAuthToken(userAuthTokenEntity);

            userDao.updateUser(userEntity);
            userEntity.setLastLoginAt(now);
            return userAuthTokenEntity;
        }
        else{
            //Control will come here if user has entered a wrong password but correct email
            //Again throw "AuthenticationFailedException"
            //First string is an Exception code - You can create your own code desired for this exception(e.g. ATH-002)
            //Second string is an Exception message - You can create any user friendly message which indicates that password is wrong(e.g. Password Failed)
            //Write code here//
            throw new AuthenticationFailedException("ATH-002", "Password failed");
        }
    }
}


