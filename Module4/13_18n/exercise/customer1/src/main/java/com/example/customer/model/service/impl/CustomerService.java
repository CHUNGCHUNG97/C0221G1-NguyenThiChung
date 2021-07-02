package com.example.customer.model.service.impl;

import com.example.customer.model.entity.Customer;
import com.example.customer.model.repository.CustomerRepository;
import com.example.customer.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
