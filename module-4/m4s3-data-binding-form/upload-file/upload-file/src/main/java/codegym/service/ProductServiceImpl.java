package codegym.service;

import codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private static final List<Product> PRODUCTS = new ArrayList<>();
    @Override
    public List<Product> findAll() {
        return PRODUCTS;
    }

    @Override
    public void save(Product product) {
        PRODUCTS.add(product);
    }

    @Override
    public Product findById(int id) {
        return PRODUCTS.get(id);
    }

    @Override
    public void update(int id, Product product) {
        for (Product p : PRODUCTS) {
            if (p.getId() == id) {
                p = product;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i <= PRODUCTS.size(); i++) {
            if (PRODUCTS.get(id).getId() == id) {
                PRODUCTS.remove(i);
                break;
            }
        }
    }
}
