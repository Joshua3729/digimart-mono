package com.ecommerce.com.digimart.services.impl;

import com.ecommerce.com.digimart.entities.Product;
import com.ecommerce.com.digimart.services.base.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService
{
    @Override
    public List<Product> getAllProducts()
    {
        return List.of();
    }

    @Override
    public Product getProductById(int id)
    {
        return null;
    }
}
