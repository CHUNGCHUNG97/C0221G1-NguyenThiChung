package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void add(Product product);

    void update(int id, Product product);

    Product remove(int id);

}
