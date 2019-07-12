package com.upgrad.proman.service.entity.business;

import com.upgrad.proman.service.entity.entity.UserEntity;
import com.upgrad.proman.service.entity.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SignupBusinessService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordCryptographyProvider passwordCryptographyProvider;

    @Autowired
    private UserBusinessService userBusinessService;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity signup(UserEntity userEntity){
        return userBusinessService.createUser(userEntity);
    }
}
