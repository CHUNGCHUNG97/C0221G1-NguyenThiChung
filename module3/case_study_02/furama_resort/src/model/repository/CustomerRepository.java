package model.repository;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerRepository {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Samsung"));
        customers.put(2, new Customer(2, "Nokia"));
    }


    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }


    public Customer findById(int id) {
        return customers.get(id);
    }


    public void add(Customer customer) {
        customers.put(customer.getId(), customer);
    }


    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    public Customer remove(int id) {
        customers.remove(id);
        return null;
    }


    public List<Customer> search(String name) {
        return findAll().stream().filter(ob -> ob.getFullName().contains(name)).collect(Collectors.toList());
    }
}
