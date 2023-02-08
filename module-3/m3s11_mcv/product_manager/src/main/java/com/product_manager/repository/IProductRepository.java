package com.product_manager.repository;

import com.product_manager.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    void remove(int id);
    void update(int id, Product product);
    Product findById(int id);
    List<Product> findByName(String name);
}
