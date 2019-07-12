package com.upgrad.technical.api.controller;

import com.upgrad.technical.api.model.ImageUploadRequest;
import com.upgrad.technical.api.model.ImageUploadResponse;
import com.upgrad.technical.api.model.SignupUserRequest;
import com.upgrad.technical.api.model.SignupUserResponse;
import com.upgrad.technical.service.business.ImageUploadService;
import com.upgrad.technical.service.business.SignupBusinessService;
import com.upgrad.technical.service.entity.ImageEntity;
import com.upgrad.technical.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class ImageUploadController {

    @Autowired
    private ImageUploadService imageUploadService;

    //Write the annotation to map this method to URL request of type '/imageupload'
    //Note that this method is listening to Http request of POST type,and it consumes and produces Json
    //
    @RequestMapping(method = RequestMethod.POST, path = "/imageupload", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ImageUploadResponse> imageupload(final ImageUploadRequest imageUploadRequest) {
        final ImageEntity imageEntity = new ImageEntity();

        //setting Image attribute of imageEntity using imageUploadRequest
        imageEntity.setImage(imageUploadRequest.getImage());

        //set Name attribute of imageEntity using imageUploadRequest
        //Write code here//
        imageEntity.setName(imageUploadRequest.getName());
        //set Description attribute of imageEntity using imageUploadRequest
        //Write code here//
        imageEntity.setDescription(imageUploadRequest.getDescription());
        //set Uuid attribute of imageEntity using imageUploadRequest
        //Write code here//
        imageEntity.setUuid(UUID.randomUUID().toString());

        imageEntity.setNo_of_likes(0);
        imageEntity.setCreated_at(ZonedDateTime.now());
        //set the status as "REGISTERED" as the image is not live yet.
        //Note that admin needs to review the image to set its status as "ACTIVE"
        imageEntity.setStatus("REGISTERED");

        final ImageEntity createdimageEntity = imageUploadService.upload(imageEntity);
        ImageUploadResponse imageUploadResponse = new ImageUploadResponse().id(createdimageEntity.getUuid()).status("IMAGE SUCCESSFULLY REGISTERED");
        return new ResponseEntity<ImageUploadResponse>(imageUploadResponse, HttpStatus.CREATED);
    }
}
