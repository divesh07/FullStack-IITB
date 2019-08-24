/*
 * Copyright 2017-2018, Redux Software.
 *
 * File: AuthenticationController.java
 * Date: Sep 28, 2017
 * Author: P7107311
 * URL: www.redux.com
 */
package apps.proman.api.controller;

import static apps.proman.api.data.ResourceConstants.BASE_URL_AUTH;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.UUID;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apps.proman.api.controller.ext.ResponseBuilder;
import apps.proman.api.controller.provider.BasicAuthDecoder;
import apps.proman.api.controller.provider.BearerAuthDecoder;
import apps.proman.api.model.AuthorizedUserResponse;
import apps.proman.api.model.RoleDetailsType;
import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.user.business.AuthTokenService;
import apps.proman.service.user.business.AuthenticationService;
import apps.proman.service.user.model.AuthorizedUser;

@RestController
@CrossOrigin
@RequestMapping(path = BASE_URL_AUTH)
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthTokenService authTokenService;


    @RequestMapping(method = POST, path = "/login", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AuthorizedUserResponse> login(@RequestHeader final String authorization) throws ApplicationException {
        final BasicAuthDecoder basicAuthDecoder = new BasicAuthDecoder(authorization);
        final AuthorizedUser authorizedUser = authenticationService.authenticate(basicAuthDecoder.getUsername(), basicAuthDecoder.getPassword());
        return ResponseBuilder.ok().payload(toResponse(authorizedUser))
                .accessToken(authorizedUser.getAccessToken()).build();
    }

    @RequestMapping(method = POST, path = "/logout")
    public void logout(@RequestHeader final String authorization) throws ApplicationException {
        final BearerAuthDecoder authDecoder = new BearerAuthDecoder(authorization);
        authTokenService.invalidateToken(authDecoder.getAccessToken());
    }

    private AuthorizedUserResponse toResponse(final AuthorizedUser authorizedUser) {

        final AuthorizedUserResponse authorizedUserResponse = new AuthorizedUserResponse()
                .id(UUID.fromString(authorizedUser.getId()))
                .firstName(authorizedUser.getFirstName()).lastName(authorizedUser.getLastName())
                .emailAddress(authorizedUser.getEmailAddress()).mobilePhone(authorizedUser.getMobilePhoneNumber())
                .lastLoginTime(authorizedUser.getLastLoginTime())
                .status(authorizedUser.getStatus().name())
                .accessToken(authorizedUser.getAccessToken());
        if (authorizedUser.getRole() != null) {
            authorizedUserResponse.role(new RoleDetailsType().id(authorizedUser.getRole().getUuid()).name(authorizedUser.getRole().getName()));
        }
        return authorizedUserResponse;
    }

}