package codegym.shopping_cart.service;

import codegym.shopping_cart.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
