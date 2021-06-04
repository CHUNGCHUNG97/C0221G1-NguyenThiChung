package model.service.customer;

import model.bean.Customer;
import model.repository.customer.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public void add(Customer customer, int type) {
        customerRepository.insertCustomer(customer, type);
    }


    @Override
    public void update(Customer customer, int type) {
        customerRepository.update(customer, type);
    }

    @Override
    public boolean remove(int id) {
        return customerRepository.remove(id);
    }

    @Override
    public List<Customer> pagination(int page, int pageSize) {
        return customerRepository.getListByPagination(page, pageSize);
    }

    @Override
    public long count() {
        return customerRepository.countAll();
    }


//
//    @Override
//    public Customer remove(int id) {
//        customerRepository.remove(id);
//        return null;
//    }
//
//    @Override
//    public List<Customer> search(String name) {
//        return customerRepository.search(name);
//    }
}
