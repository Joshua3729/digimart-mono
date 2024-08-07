package com.ecommerce.com.digimart.services.impl;


import com.ecommerce.com.digimart.entities.User;
import com.ecommerce.com.digimart.services.Firebase.FirebaseUserService;
import com.ecommerce.com.digimart.services.base.IAuthService;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class AuthService implements IAuthService {

    FirebaseUserService firebaseUserService;
    @Autowired
    private com.ecommerce.com.digimart.dbms.UserServiceDBMS DBMSUserService;

    @Override
    public boolean registerUser(String firstName, String lastName, String email, String password) {
        try {
            UserRecord firebaseUser  = firebaseUserService.createUser(email, password);

            User preparedUser = User.builder().
                                firstName(firstName).
                                lastName(lastName).
                                firebaseUid(firebaseUser.getUid()).build();

            this.DBMSUserService.createUser(preparedUser);

            return true;
        } catch (FirebaseAuthException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
