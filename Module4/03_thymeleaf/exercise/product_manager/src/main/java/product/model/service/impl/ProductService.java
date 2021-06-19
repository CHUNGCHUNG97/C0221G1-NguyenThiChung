package product.model.service.impl;

import org.springframework.stereotype.Service;
import product.model.bean.Product;
import product.model.service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 6", 5000000, 2));
        products.put(2, new Product(2, "Iphone 7", 7000000, 1));
        products.put(3, new Product(3, "Iphone 8", 9000000, 5));
        products.put(4, new Product(4, "Iphone 9", 9500000, 3));
        products.put(5, new Product(5, "Iphone x", 11000000, 1));
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
    public Product findById(int id) {
        return products.get(id);
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
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getValue().getName().toLowerCase().contains(name.toLowerCase())) {
                productList.add(entry.getValue());
            }


        }
        return productList;
    }
}
