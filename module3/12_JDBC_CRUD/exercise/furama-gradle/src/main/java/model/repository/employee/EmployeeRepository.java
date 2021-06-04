package model.repository.employee;



import model.bean.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeRepository {
    private static Map<Integer, Employee> employees;

    static {
        employees = new HashMap<>();
        employees.put(1, new Employee(1, "Samsung"));
        employees.put(2, new Employee(2, "Nokia"));
    }


    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }


    public Employee findById(int id) {
        return employees.get(id);
    }


    public void add(Employee employee) {
        employees.put(employee.getId(), employee);
    }


    public void update(int id, Employee employee) {
        employees.put(id, employee);
    }

    public Employee remove(int id) {
        employees.remove(id);
        return null;
    }


    public List<Employee> search(String name) {
        return findAll().stream().filter(ob -> ob.getFullName().contains(name)).collect(Collectors.toList());
    }
}
