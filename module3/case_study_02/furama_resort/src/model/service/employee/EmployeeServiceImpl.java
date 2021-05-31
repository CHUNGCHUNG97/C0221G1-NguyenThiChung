package model.service.employee;

import model.Customer;
import model.Employee;
import model.repository.EmployeeRepository;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.add(employee);
    }

    @Override
    public void update(int id, Employee employee) {
        employeeRepository.update(id, employee);
    }

    @Override
    public Employee remove(int id) {
        employeeRepository.remove(id);
        return null;
    }

    @Override
    public List<Employee> search(String name) {
        return employeeRepository.search(name);
    }
}
