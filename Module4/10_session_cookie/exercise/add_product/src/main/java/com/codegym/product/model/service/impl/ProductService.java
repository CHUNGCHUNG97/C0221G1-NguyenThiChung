package com.codegym.product.model.service.impl;

import com.codegym.product.model.entity.Cart;
import com.codegym.product.model.entity.Product;
import com.codegym.product.model.repository.ProductRepository;
import com.codegym.product.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProductInCart(Long id, Cart cart) {
        cart.removeProduct(id);
    }


}
