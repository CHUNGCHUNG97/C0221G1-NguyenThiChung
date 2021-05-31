package model.service.customer;

import model.Customer;
import model.Employee;
import model.repository.CustomerRepository;
import model.repository.EmployeeRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id, customer);
    }

    @Override
    public Customer remove(int id) {
        customerRepository.remove(id);
        return null;
    }

    @Override
    public List<Customer> search(String name) {
        return customerRepository.search(name);
    }
}
