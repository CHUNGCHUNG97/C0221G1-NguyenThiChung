package model.repository.employee;

import model.bean.Employee;
import model.bean.Division;
import model.bean.EducationDegree;
import model.bean.Position;
import model.bean.User;
import model.repository.DatabaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private static final String GET_ALL = "select *from employee " +
            " left join position p on employee.position_id = p.position_id\n" +
            " left join education_degree ed on employee.education_degree_id = ed.education_degree_id\n" +
            " left join division d on employee.division_id = d.divison_id\n" +
            " left join user u on employee.user_name = u.user_name;";
    private static final String INSERT_INTO = "insert into employee (employee_name, position_id, education_degree_id, " +
            " division_id, employee_birthday, employee_id_card,\n" +
            " employee_salary, employee_phone, employee_email, employee_address, user_name)\n" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;

    public List<Employee> findAll() {
        connection = databaseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int idPosition = resultSet.getInt("position_id");
                String namePosition = resultSet.getString("position_name");
                Position position = new Position(idPosition, namePosition);
                int idEducation = resultSet.getInt("Education_degree_id");
                String nameEducation = resultSet.getString("Education_degree_name");
                EducationDegree educationDegree = new EducationDegree(idEducation, nameEducation);
                int idDivision = resultSet.getInt("division_id");
                String nameDivision = resultSet.getString("divison_name");
                Division division = new Division(idDivision, nameDivision);
                String nameUser = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                User user = new User(nameUser, password);
                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, user);
                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    //
//    public Employee findById(int id) {
//        return employees.get(id);
//    }
//
//
    public void insertEmployee(Employee employee) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getPosition().getId());
            preparedStatement.setInt(3, employee.getEducationDegree().getId());
            preparedStatement.setInt(4, employee.getDivision().getId());
            preparedStatement.setString(5, employee.getBirthday());
            preparedStatement.setString(6, employee.getIdCard());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, employee.getUser().getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
     public void insertEmployee(Employee employee,int idPosition, int idEducation, int idDivision, String userName) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, idPosition);
            preparedStatement.setInt(3, idEducation);
            preparedStatement.setInt(4, idDivision);
            preparedStatement.setString(5, employee.getBirthday());
            preparedStatement.setString(6, employee.getIdCard());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, userName);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//
//
//    public void update(int id, Employee employee) {
//        employees.put(id, employee);
//    }
//
//    public Employee remove(int id) {
//        employees.remove(id);
//        return null;
//    }
//
//
//    public List<Employee> search(String name) {
//        return findAll().stream().filter(ob -> ob.getFullName().contains(name)).collect(Collectors.toList());
//    }
}
