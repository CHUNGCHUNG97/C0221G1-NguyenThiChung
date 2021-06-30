package com.example.customer.model.service;

import com.example.customer.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    Customer saveCustomer(Customer customer);

    void remove(Long id);
}
