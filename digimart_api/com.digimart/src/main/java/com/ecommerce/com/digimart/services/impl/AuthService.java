package com.ecommerce.com.digimart.services.impl;


import com.ecommerce.com.digimart.services.Firebase.FirebaseUserService;
import com.ecommerce.com.digimart.services.base.IAuthService;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AuthService implements IAuthService {

    FirebaseUserService firebaseUserService;

    @Override
    public boolean registerUser(String firstName, String lastName, String email, String password) {
        try {
            UserRecord firebaseUser  = firebaseUserService.createUser(email, password);

            return true;
        } catch (FirebaseAuthException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
