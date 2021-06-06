package model.repository.contract;

import model.bean.Contract;
import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;
import model.repository.DatabaseRepository;
import model.service.customer.CustomerService;
import model.service.customer.CustomerServiceImpl;
import model.service.employee.EmployeeService;
import model.service.employee.EmployeeServiceImpl;
import model.service.service.ServiceService;
import model.service.service.ServiceServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ContractRepository {
    private static final String GET_ALL = "select *\n" +
            "from contract\n" +
            "         left join customer c on contract.customer_id = c.customer_id\n" +
            "         left join employee e on contract.employee_id = e.employee_id\n" +
            "         left join service s on contract.service_id = s.service_id";
    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;
    EmployeeService employeeService = new EmployeeServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();

    public List<Contract> findAll() {
        connection = databaseRepository.connectDataBase();
        List<Contract> contracts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("contract_id");
                int idEmployee = resultSet.getInt("employee_id");
                Employee employee = employeeService.findById(id);
                int idCustomer = resultSet.getInt("customer_id");
                Customer customer = customerService.findById(id);
                int idService = resultSet.getInt("service_id");
                Service service = serviceService.findById(idService);
                String dateStart = resultSet.getString("contract_start_date");
                String dateEnd = resultSet.getString("contract_end_date");
                double deposit = resultSet.getDouble("contract_deposit");
                double totalMoney = resultSet.getDouble("contract_total_money");
                Contract contract = new Contract(id, dateStart, dateEnd, deposit, totalMoney, employee, customer, service);
                contracts.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contracts;

    }

//
//    public Contract findById(int id) {
//        return contracts.get(id);
//    }
//
//
//    public void add(Contract contract) {
//        contracts.put(contract.getId(), contract);
//    }
//
//
//    public void update(int id, Contract contract) {
//        contracts.put(id, contract);
//    }
//
//    public Contract remove(int id) {
//        contracts.remove(id);
//        return null;
//    }
//
//
//    public List<Contract> search(String name) {
//        return findAll().stream().filter(ob -> ob.getName().contains(name)).collect(Collectors.toList());
//    }
}
