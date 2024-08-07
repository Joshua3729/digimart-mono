package com.ecommerce.com.digimart.services.base;

public interface IAuthService {
    public boolean registerUser(String firstName, String lastName, String email, String password);
}
