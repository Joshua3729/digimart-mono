package com.ecommerce.com.digimart.services.base;

import com.ecommerce.com.digimart.entities.Product;

import java.util.List;

public interface IProductService
{
    List<Product> getAllProducts();
   Product getProductById(int id);
}
