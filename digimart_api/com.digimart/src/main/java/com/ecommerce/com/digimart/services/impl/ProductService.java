package com.ecommerce.com.digimart.services.impl;

import com.ecommerce.com.digimart.entities.Product;
import com.ecommerce.com.digimart.services.base.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("local")
@Service
public class ProductService implements IProductService
{
    @Autowired
    private com.ecommerce.com.digimart.dbms.ProductServiceDBMS DBMSProductService;

    @Override
    public List<Product> getAllProducts(String category)
    {
        return DBMSProductService.getProductsByCategory(category);
    }

    @Override
    public Product getProductById(int id)
    {
        return null;
    }
}
