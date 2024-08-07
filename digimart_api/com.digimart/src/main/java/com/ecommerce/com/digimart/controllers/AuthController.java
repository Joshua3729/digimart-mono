package com.ecommerce.com.digimart.controllers;

import com.ecommerce.com.digimart.entities.requests.AuthRegisterRequest;
import com.ecommerce.com.digimart.services.impl.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerUser(@Valid @RequestBody AuthRegisterRequest authRegisterRequest) {

        boolean userCreated = authService.registerUser(authRegisterRequest.getFirstName(), authRegisterRequest.getLastName(), authRegisterRequest.getEmail(), authRegisterRequest.getPassword());

        return new ResponseEntity<>(userCreated, HttpStatus.OK);
    }

}
