package apps.proman.api.controller;

import static apps.proman.api.controller.transformer.UserTransformer.toEntity;
import static apps.proman.api.controller.transformer.UserTransformer.toSignupResponse;
import static apps.proman.api.data.ResourceConstants.BASE_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apps.proman.api.controller.ext.ResponseBuilder;
import apps.proman.api.model.SignupUserRequest;
import apps.proman.api.model.SignupUserResponse;
import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.user.business.UserService;
import apps.proman.service.user.entity.UserEntity;
import apps.proman.service.user.model.RoleType;
import apps.proman.service.user.model.UserStatus;

@RestController
@CrossOrigin
@RequestMapping(BASE_URL)
public class SignupController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = POST, path = "/signup", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SignupUserResponse> signup(@RequestBody final SignupUserRequest signupUserRequest) throws ApplicationException {

        final UserEntity newUserEntity = toEntity(signupUserRequest);
        newUserEntity.setStatus(UserStatus.REGISTERED.getCode());

        final UserEntity registeredUser = userService.createUser(newUserEntity, RoleType.TEAM_MEMBER.getCode());
        return ResponseBuilder.created().payload(toSignupResponse(registeredUser)).build();
    }

}
