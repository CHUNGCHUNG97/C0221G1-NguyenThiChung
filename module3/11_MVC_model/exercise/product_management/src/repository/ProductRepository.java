package repository;

import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Samsung", 10000000, "Samsung"));
        products.put(2, new Product(2, "Nokia", 10000000, "Nokia"));
        products.put(3, new Product(3, "Iphone", 10000000, "Apple"));
        products.put(4, new Product(4, "Xiaomi", 10000000, "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void add(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public Product remove(int id) {
        products.remove(id);
        return null;
    }
}
