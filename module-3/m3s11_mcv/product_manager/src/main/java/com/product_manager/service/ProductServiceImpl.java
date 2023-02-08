package com.product_manager.service;

import com.product_manager.model.Product;
import com.product_manager.repository.IProductRepository;
import com.product_manager.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private static final IProductRepository PRODUCT_REPOSITORY = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return PRODUCT_REPOSITORY.findAll();
    }

    @Override
    public void save(Product product) {
        PRODUCT_REPOSITORY.save(product);
    }

    @Override
    public void remove(int id) {
        PRODUCT_REPOSITORY.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        PRODUCT_REPOSITORY.update(id, product);
    }

    @Override
    public Product findById(int id) {
        return PRODUCT_REPOSITORY.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return PRODUCT_REPOSITORY.findByName(name);
    }
}
