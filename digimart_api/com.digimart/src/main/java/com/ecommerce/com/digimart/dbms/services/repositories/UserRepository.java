package com.ecommerce.com.digimart.dbms.services.repositories;

import com.ecommerce.com.digimart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
