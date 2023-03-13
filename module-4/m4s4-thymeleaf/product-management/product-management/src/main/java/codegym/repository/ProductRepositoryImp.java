package codegym.repository;

import codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImp implements ProductRepository{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Bike 1", 2300000, "New", "Toyota"));
        products.put(2, new Product(2, "Bike 2", 2500000, "Old", "Honda"));
        products.put(3, new Product(3, "Bike 3", 2700000, "Like new", "Mazda"));
        products.put(4, new Product(4, "Bike 4", 1200000, "Like old", "Suburu"));
        products.put(5, new Product(5, "Bike 5", 9800000, "Pretty old", "Ford"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().contains(name)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
