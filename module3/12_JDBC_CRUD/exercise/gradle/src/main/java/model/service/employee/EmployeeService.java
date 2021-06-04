package model.service.employee;





import model.bean.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    void add(Employee employee);

    void update(int id, Employee employee);

    Employee remove(int id);

    List<Employee> search(String name);

}
