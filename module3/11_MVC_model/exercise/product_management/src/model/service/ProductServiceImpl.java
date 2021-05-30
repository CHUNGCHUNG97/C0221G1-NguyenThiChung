package model.service;

import model.Product;
import model.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public Product remove(int id) {
        productRepository.remove(id);
        return null;
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }
}
