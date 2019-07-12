package com.upgrad.proman.service.entity.business;

import com.upgrad.proman.service.entity.dao.UserDao;
import com.upgrad.proman.service.entity.entity.RoleEntity;
import com.upgrad.proman.service.entity.entity.UserAuthTokenEntity;
import com.upgrad.proman.service.entity.entity.UserEntity;
import com.upgrad.proman.service.entity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBusinessService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordCryptographyProvider cryptographyProvider;

    public UserEntity getUser(final String userUuid, final String authorizationToken) throws ResourceNotFoundException {
        UserAuthTokenEntity userAuthTokenEntity = userDao.getUserAuthToken(authorizationToken);
        RoleEntity role = userAuthTokenEntity.getUser().getRole();
        if ( role.getUuid() == 101) {
            UserEntity userEntity = userDao.getUser(userUuid);
            if (null == userEntity) {
                throw new ResourceNotFoundException("USER-001", "User not found");
            }
            return userEntity;
        }
        throw new ResourceNotFoundException("USER-001", "User not found");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity createUser(final UserEntity userEntity){
        // creates user with default password
        // Encrypyt the password
        String password = userEntity.getPassword();
        if ( null == password) {
            password = "proman@123";
        }

        final String[] encryptedText = cryptographyProvider.encrypt(password);
        userEntity.setSalt(encryptedText[0]);
        userEntity.setPassword(encryptedText[1]);

        return userDao.createUser(userEntity);
    }
}
