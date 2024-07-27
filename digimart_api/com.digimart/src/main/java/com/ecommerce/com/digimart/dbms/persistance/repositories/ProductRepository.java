package com.ecommerce.com.digimart.dbms.persistance.repositories;

import com.ecommerce.com.digimart.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    List<Product> findAllByCategory(String category);
}