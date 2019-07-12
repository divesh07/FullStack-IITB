package com.upgrad.technical.service.dao;

import com.upgrad.technical.service.entity.UserEntity;
import com.upgrad.technical.service.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao {

    //Write the annotation which handles entities holding data which are to be persisted in some persistence store like a database.
    @PersistenceContext
    private EntityManager entityManager;

    public UserEntity createUser(UserEntity userEntity) {
        //You need to attach the userEntity from transient state to persistence context(to persist to a database)
        //Call the persist() method for entityManager object and pass userEntity as an argument.
        //Note that the return type of persist() method is void.
        //Write code here//
        entityManager.persist(userEntity);
        return  userEntity;
    }
//This method returns userEntity
}