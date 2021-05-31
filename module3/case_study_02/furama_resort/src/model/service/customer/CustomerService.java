package model.service.customer;

import model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void add(Customer customer);

    void update(int id, Customer customer);

    Customer remove(int id);

    List<Customer> search(String name);
}
