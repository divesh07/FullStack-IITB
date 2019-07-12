package com.upgrad.proman.api.controller.controller;

import com.upgrad.proman.api.model.AuthorizedUserResponse;
import com.upgrad.proman.service.entity.business.AuthenticationService;
import com.upgrad.proman.service.entity.entity.UserAuthTokenEntity;
import com.upgrad.proman.service.entity.entity.UserEntity;
import com.upgrad.proman.service.entity.exception.AuthenticationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.POST, path = "/auth/login", produces = "application/json")
    public ResponseEntity<AuthorizedUserResponse> login(@RequestHeader("authorization") final String authorization) throws AuthenticationFailedException {
        // Sample Base64 encoded string
        //Basic dXNlcm5hbWU6cGFzc3dvcmQ=
        byte[] decode = Base64.getDecoder().decode(authorization.split("Basic ")[1]);
        // user name and password are seperated by : in the base 64 encoding
        String decodedText = new String(decode);
        final String[] decodedArray = decodedText.split(":");
        UserAuthTokenEntity userAuthToken = authenticationService.authenticate(decodedArray[0], decodedArray[1]);
        UserEntity user = userAuthToken.getUser();
        AuthorizedUserResponse authorizedUserResponse = new AuthorizedUserResponse().id(UUID.fromString(user.getUuid()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailAddress(user.getEmail())
                .mobilePhone(user.getMobilePhone())
                .lastLoginTime(user.getLastLoginAt());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("access-token", userAuthToken.getAccessToken());

        return new ResponseEntity<>(authorizedUserResponse, httpHeaders, HttpStatus.OK);
    }
}
