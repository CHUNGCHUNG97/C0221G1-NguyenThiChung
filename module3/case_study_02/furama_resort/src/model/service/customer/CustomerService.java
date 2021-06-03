package model.service.customer;

import model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void add(Customer customer);
    void add(Customer customer, int type);

    void update(Customer customer, int type);

    public boolean remove(int id);
//
//    List<Customer> search(String name);
}
