package com.upgrad.proman.api.controller.controller;

import com.upgrad.proman.service.entity.entity.UserEntity;
import com.upgrad.proman.service.entity.business.SignupBusinessService;
import com.upgrad.proman.service.entity.type.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.upgrad.proman.api.model.SignupUserResponse;
import com.upgrad.proman.api.model.SignupUserRequest;

import java.time.ZonedDateTime;
import java.util.UUID;


@RestController
@RequestMapping("/")
public class SignUpController {

    @Autowired
    private SignupBusinessService signupBusinessService;

    @RequestMapping(method= RequestMethod.POST, path = "/signup", produces = "application/json")
    public ResponseEntity<SignupUserResponse> signup(final SignupUserRequest signupUserRequest){

        UserEntity userEntity = new UserEntity();
        userEntity.setUuid(UUID.randomUUID().toString());
        userEntity.setFirstName(signupUserRequest.getFirstName());
        userEntity.setLastName(signupUserRequest.getLastName());
        userEntity.setEmail(signupUserRequest.getEmailAddress());
        // Need to encrypt to avoid man in the middle attack
        userEntity.setPassword(signupUserRequest.getPassword());
        //Need to hash salt as well
        userEntity.setSalt("1234abc");
        // status codes 0 inactive , 1 active , 3 logged , 4 registered
        userEntity.setStatus(UserStatus.REGISTERED.getCode());
        userEntity.setCreatedAt(ZonedDateTime.now());
        userEntity.setCreatedBy("api-backend");
        userEntity.setMobilePhone(signupUserRequest.getMobileNumber());

        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        final UserEntity createdUserEntity = signupBusinessService.signup(userEntity);
        final SignupUserResponse signupUserResponse = new SignupUserResponse().id(createdUserEntity.getUuid()).status("REGISTERED");

        return new ResponseEntity<SignupUserResponse>(signupUserResponse, httpHeaders, HttpStatus.CREATED);
    }


}
