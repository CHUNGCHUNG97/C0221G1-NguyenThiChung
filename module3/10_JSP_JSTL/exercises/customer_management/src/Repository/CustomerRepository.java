package Repository;

import model.Customer;
import service.CustomerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository implements CustomerService {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Thạch", "thach@gmail.com", "Đà Nẵng"));
        customers.put(2, new Customer(2, "Chung", "chung@gmail.com", "Quảng Ngãi"));
        customers.put(3, new Customer(3, "Phú", "phu@gmail.com", "Quảng Trị"));
        customers.put(4, new Customer(4, "Thanh", "thanh@gmail.com", "Huế"));
    }

    @Override
    public List<Customer> findAll() {
//        kết nối database lấy danh sách
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
