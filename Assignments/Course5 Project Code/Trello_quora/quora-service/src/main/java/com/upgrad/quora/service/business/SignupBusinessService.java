package com.upgrad.quora.service.business;

import com.upgrad.quora.service.dao.UserDao;
import com.upgrad.quora.service.entity.UserAuthTokenEntity;
import com.upgrad.quora.service.entity.UserEntity;
import com.upgrad.quora.service.exception.AuthenticationFailedException;
import com.upgrad.quora.service.exception.SignUpRestrictedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
public class SignupBusinessService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordCryptographyProvider passwordCryptographyProvider;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity signup(UserEntity userEntity) {
        String[] encryptedText = passwordCryptographyProvider.encrypt(userEntity.getPassword());
        userEntity.setSalt(encryptedText[0]);
        userEntity.setPassword(encryptedText[1]);

        return userDao.createUser(userEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity getUserByName(final String username) throws SignUpRestrictedException {
        UserEntity userEntity = userDao.getUserByName(username);
        if (userEntity == null) {
            throw new SignUpRestrictedException("SGR-001", "'Try any other Username, this Username has already been taken.'");
        }
        return userEntity;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity getUserByEmail(final String emailAddress) throws SignUpRestrictedException {
        UserEntity userEntity = userDao.getUserByEmail(emailAddress);
        if (userEntity == null) {
            throw new SignUpRestrictedException("SGR-002", "'This user has already been registered, try with any other emailId.'");
        }
        return userEntity;
    }
}
