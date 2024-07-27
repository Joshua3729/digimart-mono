package com.ecommerce.com.digimart.services.base;

import com.ecommerce.com.digimart.entities.Product;

import java.util.List;

public interface IProductService
{
    List<Product> getAllProducts(String category);
   Product getProductById(int id);
}
