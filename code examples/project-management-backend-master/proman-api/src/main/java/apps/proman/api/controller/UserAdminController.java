package apps.proman.api.controller;

import static apps.proman.api.controller.transformer.UserTransformer.*;
import static apps.proman.api.data.ResourceConstants.BASE_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import apps.proman.api.controller.ext.ResponseBuilder;
import apps.proman.api.exception.RestException;
import apps.proman.api.model.CreateUserRequest;
import apps.proman.api.model.CreateUserResponse;
import apps.proman.api.model.UpdateUserRequest;
import apps.proman.api.model.UserDetailsResponse;
import apps.proman.api.model.UserOperationRequest;
import apps.proman.api.model.UserOperationsRequest;
import apps.proman.api.model.UserStatusType;
import apps.proman.api.model.UsersSummaryResponse;
import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.user.exception.UserErrorCode;
import apps.proman.service.user.business.RoleService;
import apps.proman.service.user.business.UserService;
import apps.proman.service.user.entity.RoleEntity;
import apps.proman.service.user.entity.UserEntity;
import apps.proman.service.common.model.SearchResult;
import apps.proman.service.user.model.UserStatus;

@RestController
@CrossOrigin
@RequestMapping(BASE_URL)
public class UserAdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @RequestMapping(method = GET, path = "/users", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UsersSummaryResponse> getUsers(@RequestHeader("authorization") String accessToken,
                                                         @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                         @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                                                         @RequestParam(value = "status", required = false) String status) {

        final SearchResult<UserEntity> searchResult;
        if (StringUtils.isEmpty(status)) {
            searchResult = userService.findUsers(page, limit);
        } else {
            searchResult = userService.findUsers(UserStatus.valueOf(toEnum(status).name()), page, limit);
        }
        return ResponseBuilder.ok().payload(toUsersSummaryResponse(page, limit, searchResult)).build();
    }

    @RequestMapping(method = GET, path = "/users/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDetailsResponse> getUser(@RequestHeader("authorization") String accessToken,
                                                       @PathVariable("id") final String userUuid)
            throws ApplicationException {

        final UserEntity userEntity = userService.findUserByUuid(userUuid);
        return ResponseBuilder.ok().payload(toUserDetailsResponse(userEntity)).build();
    }

    @RequestMapping(method = POST, path = "/users", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CreateUserResponse> createUser(@RequestHeader("authorization") String accessToken,
                                                         @RequestBody final CreateUserRequest newUserRequest) throws ApplicationException {

        final UserEntity newUserEntity = toEntity(newUserRequest);
        newUserEntity.setStatus(UserStatus.ACTIVE.getCode());

        final UserEntity createdUser = userService.createUser(newUserEntity, newUserRequest.getRole().getId());
        return ResponseBuilder.created().payload(toCreateUserResponse(createdUser)).build();
    }

    @RequestMapping(method = PUT, path = "/users/{id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateUser(@RequestHeader("authorization") String accessToken,
                                     @PathVariable("id") final String userUuid,
                                     @RequestBody final UpdateUserRequest updatedUserRequest) throws ApplicationException {

        final UserEntity updatedUserEntity = toEntity(updatedUserRequest);

        final RoleEntity roleEntity = roleService.findRoleByUuid(updatedUserRequest.getRole().getId());
        updatedUserEntity.setRole(roleEntity);

        userService.updateUser(userUuid, updatedUserEntity);
        return ResponseBuilder.ok().build();
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/users/{id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity patchBoard(@RequestHeader("authorization") String accessToken,
                                     @PathVariable("id") final String boardUuid,
                                     @RequestBody final UserOperationsRequest userOperationsRequest) throws ApplicationException {

        for (UserOperationRequest userOperationRequest : userOperationsRequest) {
            userService.changeUserStatus(boardUuid, UserStatus.valueOf(toEnum(userOperationRequest.getValue()).name()));
        }

        return ResponseBuilder.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{id}")
    public ResponseEntity deleteBoard(@RequestHeader("authorization") String accessToken,
                                      @PathVariable("id") final String userUuid) throws ApplicationException {
        userService.deleteUser(userUuid);
        return ResponseBuilder.ok().build();
    }


    private UserStatusType toEnum(final String status) {
        try {
            return UserStatusType.valueOf(status);
        } catch (IllegalArgumentException exc) {
            throw new RestException(UserErrorCode.USR_010, StringUtils.join(UserStatusType.values(), ","));
        }
    }

}
