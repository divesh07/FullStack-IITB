package com.upgrad.technical.service.dao;

import com.upgrad.technical.service.entity.UserAuthTokenEntity;
import com.upgrad.technical.service.entity.UserEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserEntity createUser(UserEntity userEntity) {
        entityManager.persist(userEntity);
        return userEntity;
    }

    public UserEntity getUserByEmail(final String email) {
        //Call the createNamedQuery() method for entityManager
        //Note that the name of the query is "userByEmail" and the query is in UserEntity class
        //Also set the parameter "email" in named query as equal to the email value received by this method
        //Also note that the query will return a single result
        //Return the UserEntity type object returned by the query
        //Write code here//
        try {
            return entityManager.createNamedQuery("userByEmail", UserEntity.class).setParameter("emai", email).getSingleResult();
        }catch (NoResultException nre){
            return null;
        }
    }

    public UserAuthTokenEntity createAuthToken(final UserAuthTokenEntity userAuthTokenEntity) {
        //Now you need to attach userAuthTokenEntity from transient state to persistence context
        //Call the persist() method for entityManager and pass userAuthToken as an argument
        //Write code here//
        entityManager.persist(userAuthTokenEntity);
        return userAuthTokenEntity;
    }

    public void updateUser(final UserEntity updatedUserEntity) {
        entityManager.merge(updatedUserEntity);
    }
}
