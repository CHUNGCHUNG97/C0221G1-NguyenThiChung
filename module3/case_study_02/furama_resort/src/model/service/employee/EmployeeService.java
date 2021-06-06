package model.service.employee;

import model.bean.Customer;
import model.bean.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    void add(Employee employee);

    void add(Employee employee, int idPosition, int idEducation, int idDivison, String username);

    public List<Employee> pagination(int page, int pageSize);

    public long count();
    void update(Employee employee,int idPosition, int idEducation, int idDivision,String userName);

    boolean remove(int id);

    List<Employee> search(String name);

}
