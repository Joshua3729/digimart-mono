package com.ecommerce.com.digimart.controllers;

import com.ecommerce.com.digimart.entities.requests.AuthRegisterRequest;
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

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerUser(@Valid @RequestBody AuthRegisterRequest authRegisterRequest) {
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

}
