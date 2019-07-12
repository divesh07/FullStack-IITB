package com.upgrad.technical.service.business;

import com.upgrad.technical.service.dao.UserDao;
import com.upgrad.technical.service.entity.UserEntity;
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

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity signup(UserEntity userEntity) {

        //We have added "PasswordCryptographyProvider.java" file and its implementation need not to be focused.(once go through the code)
        //PasswordCryptographyProvider class contains encrypt() method which takes raw password as an argument and returns an array of String
        //First element in an array contains Salt attribute.What is Salt attribute?
        // Salt attribute is used in Authentication when user enters the credentials and then we need to encrypt the password entered by the user to
        // match it with the encrypted password stored in the database.
        //Second element is encrypted password

        //Now call the encrypt() method for passwordCryptographyProvider and pass the raw password as an argument
        //userEntity contains the raw password
        //Store the value returned by the encrypt() method in an array of String
        //Write code here//
        final String[] encryptedText = passwordCryptographyProvider.encrypt(userEntity.getPassword());
        userEntity.setSalt(encryptedText[0]);
        userEntity.setPassword(encryptedText[1]);

        //Now set the Salt attribute of userEntity as the first element of an array
        //Set the Password attribute of userEntity as the second element of an array
        //Write code here//

        return userDao.createUser(userEntity);
    }
}
