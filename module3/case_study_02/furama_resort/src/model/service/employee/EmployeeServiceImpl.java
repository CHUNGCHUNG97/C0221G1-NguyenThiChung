package model.service.employee;

import model.bean.Employee;
import model.repository.employee.EmployeeRepository;

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
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public void add(Employee employee, int idPosition, int idEducation, int idDivison, String username) {
        employeeRepository.insertEmployee(employee, idPosition, idEducation, idDivison, username);
    }

    @Override
    public List<Employee> pagination(int page, int pageSize) {
        return employeeRepository.getListByPagination(page, pageSize);
    }

    @Override
    public long count() {
        return employeeRepository.countAll();
    }

    @Override
    public void update(Employee employee, int idPosition, int idEducation, int idDivision, String userName) {
        employeeRepository.update(employee, idPosition, idEducation, idDivision, userName);
    }


    @Override
    public boolean remove(int id) {
        return employeeRepository.remove(id);
    }

    @Override
    public List<Employee> search(String name) {
        return employeeRepository.search(name);
    }
}
