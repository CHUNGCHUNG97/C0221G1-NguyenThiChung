package com.codegym.product.model.service;

import com.codegym.product.model.entity.Cart;
import com.codegym.product.model.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    void deleteProductInCart(Long id, Cart cart);
}
