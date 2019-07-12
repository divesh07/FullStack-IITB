package com.upgrad.proman.api.controller.controller;

import com.upgrad.proman.api.model.CreateUserRequest;
import com.upgrad.proman.api.model.CreateUserResponse;
import com.upgrad.proman.api.model.UserDetailsResponse;
import com.upgrad.proman.api.model.UserStatusType;
import com.upgrad.proman.service.entity.business.UserBusinessService;
import com.upgrad.proman.service.entity.entity.UserEntity;
import com.upgrad.proman.service.entity.exception.ResourceNotFoundException;
import com.upgrad.proman.service.entity.type.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class UserAdminController {

    @Autowired
    private UserBusinessService userAdminBuisnessService;

    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDetailsResponse> getuser(@PathVariable("id") final String userUuid,
                                                       @RequestHeader("authorization") final String authorization) throws ResourceNotFoundException {
        final UserEntity userEntity = userAdminBuisnessService.getUser(userUuid,authorization);
        final UserDetailsResponse userDetailsResponse = new UserDetailsResponse().id(((UserEntity) userEntity).getUuid()).firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .emailAddress(userEntity.getEmail())
                .mobileNumber(userEntity.getMobilePhone())
                .status(UserStatusType.valueOf(UserStatus.getEnum(userEntity.getStatus()).name()));
        return new ResponseEntity<UserDetailsResponse>(userDetailsResponse, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody final CreateUserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUuid(UUID.randomUUID().toString());
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setEmail(userRequest.getEmailAddress());
        userEntity.setMobilePhone(userRequest.getMobileNumber());
        userEntity.setStatus(UserStatus.ACTIVE.getCode());
        userEntity.setCreatedAt(ZonedDateTime.now());
        userEntity.setCreatedBy("api-backend");

        final UserEntity createdUser = userAdminBuisnessService.createUser(userEntity);
        CreateUserResponse userResponse = new CreateUserResponse().id(createdUser.getUuid()).status(UserStatusType.ACTIVE);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
}
