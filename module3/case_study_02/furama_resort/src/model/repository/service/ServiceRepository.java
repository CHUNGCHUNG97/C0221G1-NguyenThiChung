package model.repository.service;

import model.bean.AttachService;
import model.bean.Service;
import model.bean.TypeRent;
import model.bean.TypeService;
import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceRepository {
    private final String GET_ALL = "SELECT * from service";
    private final String GET_TYPE_RENT_BY_ID = "select * from rent_type where rent_type_id=?;";
    private final String GET_TYPE_SERVICE_BY_ID = "select * from service_type where service_type_id=?;";
    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;

    public TypeRent getTypeRent(int id) {
        Connection connection = databaseRepository.connectDataBase();
        TypeRent typeRent = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TYPE_RENT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("rent_type_id");
                String name = resultSet.getString("rent_type_name");
                double cost = resultSet.getDouble("rent_type_cost");
                typeRent = new TypeRent(id1, name, cost);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeRent;
    }

    public TypeService getTypeService(int id) {
        Connection connection = databaseRepository.connectDataBase();
        TypeService typeService = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TYPE_SERVICE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("service_type_id");
                String name = resultSet.getString("service_type_name");
                typeService = new TypeService(id1, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeService;
    }

    public List<Service> findAll() {
        List<Service> services = new ArrayList<>();
        try {
            connection = databaseRepository.connectDataBase();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("service_id");
                String nameService = resultSet.getString("service_name");
                int areaService = resultSet.getInt("service_area");
                double costService = resultSet.getDouble("service_cost");
                int maxPeopleService = resultSet.getInt("service_max_people");
                int typeRentId = resultSet.getInt("rent_type_id");
                //GET TYPE RENT BY ID;
                TypeRent typeRent = getTypeRent(typeRentId);
                int typeServiceId = resultSet.getInt("service_type_id");
                //GET BY ID
                TypeService typeService = getTypeService(typeServiceId);

                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double areaPool = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");

                Service service = new Service(id, nameService, areaService, costService, maxPeopleService,
                        typeRent, typeService, standardRoom, descriptionOtherConvenience, areaPool, numberOfFloors);
                services.add(service);
            }

            return services;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }


    }


}
