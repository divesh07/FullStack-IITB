package com.upgrad.proman.service.entity.dao;

import com.upgrad.proman.service.entity.entity.UserAuthTokenEntity;
import com.upgrad.proman.service.entity.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao {

    // Container managed Entity manager , instead of Application Managed
    // In container managed EM , we dont have to create an instance
    @PersistenceContext
    private EntityManager entityManager;

    public UserEntity createUser(UserEntity userEntity){
        entityManager.persist(userEntity);
        return userEntity;
    }

    public UserEntity getUser( final String userUuid){
        try {
            return entityManager.createNamedQuery("userByUuid", UserEntity.class).setParameter("uuid", userUuid).getSingleResult();
        }catch (NoResultException nre){
            return null;
        }
    }

    public UserEntity getUserByEmail(final String email){
        try {
            return entityManager.createNamedQuery("userByEmail", UserEntity.class).setParameter("email", email).getSingleResult();
        }catch (NoResultException nre){
            return null;
        }
    }

    public UserAuthTokenEntity createAuthToken(final UserAuthTokenEntity userAuthTokenEntity){
        entityManager.persist(userAuthTokenEntity);
        return userAuthTokenEntity;
    }

    public void updateUser(final UserEntity updatedUserEntity){
        entityManager.merge(updatedUserEntity);
    }

    public UserAuthTokenEntity getUserAuthToken(final String accessToken){
        try {
            return entityManager.createNamedQuery("userAuthTokenByAccessToken", UserAuthTokenEntity.class)
                    .setParameter("accessToken", accessToken).getSingleResult();
        }catch (NoResultException nre){
            return null;
        }
    }
}
