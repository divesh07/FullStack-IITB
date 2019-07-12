package com.upgrad.technical.service.dao;

import com.upgrad.technical.service.entity.ImageEntity;
import com.upgrad.technical.service.entity.UserAuthTokenEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class ImageDao {


    @PersistenceContext
    private EntityManager entityManager;
    public ImageEntity createImage(ImageEntity imageEntity) {
        //In this method we need to attach imageEntity to persistence context
        //Call persist() method for entityManager and pass imageEntity as argument
        //Write code here//
        entityManager.persist(imageEntity);
        return imageEntity;
    }

}
