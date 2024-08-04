package com.ecommerce.com.digimart.dbms;

import com.ecommerce.com.digimart.dbms.services.repositories.ProductRepository;
import com.ecommerce.com.digimart.entities.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ProductServiceDBMS {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getProductsByCategory(String category)
    {
        return productRepository.findAllByCategory(category);
    }
}
