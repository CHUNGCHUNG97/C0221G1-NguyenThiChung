package model.repository.service;


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

public class ServiceRepository {
    private final String GET_ALL = "select *\n" +
            "from service\n" +
            "         left join service_type st on service.service_type_id = st.service_type_id\n" +
            "         left join rent_type rt on service.rent_type_id = rt.rent_type_id;";
    private final String INSERT_INTO_SERVICE = "insert into service(service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id,\n" +
            "                    standard_room, description_other_convenience, pool_area, number_of_floors)\n" +
            "values (?,?,?,?,?,?,?,?,?,?);";
    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;

    public void insertService(Service service) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_INTO_SERVICE);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
                int idTypeRent = resultSet.getInt("rent_type_id");
                String nameTypeRent = resultSet.getString("rent_type_name");
                double costTypeRent = resultSet.getDouble("rent_type_cost");
                //GET TYPE RENT BY ID;
                TypeRent typeRent = new TypeRent(idTypeRent, nameTypeRent, costTypeRent);
                int typeServiceId = resultSet.getInt("service_type_id");
                String nameTypeService = resultSet.getString("service_type_name");
                //GET BY ID
                TypeService typeService = new TypeService(typeServiceId, nameTypeService);

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
