package com.ecommerce.com.digimart.dbms;

import com.ecommerce.com.digimart.dbms.services.repositories.ProductRepository;
import com.ecommerce.com.digimart.dbms.services.repositories.UserRepository;
import com.ecommerce.com.digimart.entities.Product;
import com.ecommerce.com.digimart.entities.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class UserServiceDBMS {
    @Autowired
    UserRepository userRepository;

    public boolean createUser(User user)
    {
        userRepository.save(user);
        return true;
    }
}
