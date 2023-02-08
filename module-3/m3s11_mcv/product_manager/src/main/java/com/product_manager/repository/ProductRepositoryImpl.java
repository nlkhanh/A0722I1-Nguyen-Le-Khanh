package com.product_manager.repository;

import com.product_manager.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository {
    private static final Map<Integer, Product> PRODUCT_MAP = new HashMap<>();

    static {
        PRODUCT_MAP.put(1, new Product(1,"Camry", 1.25, "Car", "Toyota"));
        PRODUCT_MAP.put(2, new Product(2, "XSR 155", 0.67, "Motorbike", "Yamaha"));
        PRODUCT_MAP.put(3, new Product(3, "GIANT ATX 660 2022", 0.05, "Bicycle", "Micro-shift"));
        PRODUCT_MAP.put(4, new Product(4, "Taco", 3.2, "Truck", "Truong Hai"));
        PRODUCT_MAP.put(5, new Product(5, "Titanic", 10.5, "Ship", "England"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(PRODUCT_MAP.values());
    }

    @Override
    public void save(Product product) {
        PRODUCT_MAP.put(product.getId() ,product);
    }

    @Override
    public void remove(int id) {
        PRODUCT_MAP.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        PRODUCT_MAP.put(id, product);
    }

    @Override
    public Product findById(int id) {
        return PRODUCT_MAP.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product: PRODUCT_MAP.values()) {
            if (product.getName().equals(name)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
