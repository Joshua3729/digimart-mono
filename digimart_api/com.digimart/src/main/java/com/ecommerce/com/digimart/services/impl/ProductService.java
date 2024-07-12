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
        Product product = new Product();
        Product[] items = new Product[] {product};
        return List.of(items);
    }

    @Override
    public Product getProductById(int id)
    {
        return null;
    }
}
