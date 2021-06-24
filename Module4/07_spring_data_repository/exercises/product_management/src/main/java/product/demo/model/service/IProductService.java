package product.demo.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import product.demo.model.entity.Product;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    void create(Product product);

    void update(Product product);

    void delete(Product product);

    Product findById(Integer id);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
