package com.upgrad.technical.service.dao;

import com.upgrad.technical.service.entity.ImageEntity;
import com.upgrad.technical.service.entity.UserAuthTokenEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class ImageDao {


    @PersistenceContext
    private EntityManager entityManager;

    public ImageEntity createImage(ImageEntity imageEntity) {
        entityManager.persist(imageEntity);
        return imageEntity;
    }

    public UserAuthTokenEntity getUserAuthToken(final String accesstoken) {
        //Complete this method to get the record from user_auth_tokens table with corresponding accesstoken received as an argument
        //This method returns UserAuthTokenEntity type object if the record is found and returns null if NoResultException is caught
        //Examine the query that has been written in UserAuthTokenEntity
        //Write code here//
        try {
            return entityManager.createNamedQuery("userAuthTokenByAccessToken", UserAuthTokenEntity.class)
                    .setParameter("accessToken", accesstoken).getSingleResult();
        }catch (NoResultException nre){
            return null;
        }
    }
}
