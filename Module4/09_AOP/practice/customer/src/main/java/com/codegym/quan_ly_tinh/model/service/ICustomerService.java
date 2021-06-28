package com.codegym.quan_ly_tinh.model.service;

import com.codegym.quan_ly_tinh.model.entity.Customer;
import com.codegym.quan_ly_tinh.model.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable) throws Exception;

    Optional<Customer> findById(Long id) throws Exception;

    Customer save(Customer customer) throws EmailException;

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
