package com.upgrad.technical.service.business;


import com.upgrad.technical.service.dao.ImageDao;
import com.upgrad.technical.service.dao.UserDao;
import com.upgrad.technical.service.entity.ImageEntity;
import com.upgrad.technical.service.exception.ImageNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private ImageDao imageDao;

    public ImageEntity getImage(final String imageUuid) throws ImageNotFoundException {

        //Call getImage() method for imageDao and pass imageUuid as an argument
        //Receive the ImageEntity type object returned by getImage() method and return that object
        //Also throw a user defined exception (ImageNotFoundException) if ImageEntity type object returned is null
        //Note that ImageNotFoundException takes two argument
        //First argument is of String type and is an exception code(e.g. IMG-001)
        //Second argument is of String type and is an exception message(e.g. Image with given uuid not found)
        final ImageEntity imageEntity = imageDao.getImage(imageUuid);
        if ( imageEntity == null){
            throw new ImageNotFoundException("IMG-01", "Image with given uuid not found");
        }
        return imageEntity;
    }
}
