package model.repository;

import model.bean.Category;
import model.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductRepository {
    private static final String GET_ALL = "select * from product left join category c on product.category_id = c.id;";
    private static final String INSERT_INTO_STUDENT = "insert into product(name, price, quantity, color, description, category_id) " +
            " VALUES (?,?,?,?,?,?);";
    private static final String FIND_BY_ID = "select * from product left join category c on product.category_id = c.id" +
            " where product.id=?";

    private static final String UPDATE = "update product set name=?,price=?,quantity=?,color=?,description=?,category_id=? " +
            " where product.id=?;";
    private static final String DELETE = "DELETE FROM product WHERE id=?;";
    private static String SEARCH = "select * from product left join category c on product.category_id = c.id\n" +
            " where product.name like ?;";


    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;

    public List<Product> search(String name) {
        connection = databaseRepository.connectDataBase();
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product.id");
                String name1 = resultSet.getString("product.name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("c.name");
                Category category = new Category(categoryId, categoryName);
                Product product = new Product(id, name1, price, quantity, color, description, category);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean delete(int id) {
        connection = databaseRepository.connectDataBase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    public Product findById(int id) throws SQLException {
        connection = databaseRepository.connectDataBase();
        Product product = null;

        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id1 = resultSet.getInt("id");
            String name = resultSet.getString("product.name");
            double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            int categoryId = resultSet.getInt("category_id");
            String categoryName = resultSet.getString("c.name");
            Category category = new Category(categoryId, categoryName);
            product = new Product(id1, name, price, quantity, color, description, category);
        }

        return product;
    }

    public void update(Product product, int categoryId) throws SQLException {
        connection = databaseRepository.connectDataBase();

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getDescription());
        preparedStatement.setInt(6, categoryId);
        preparedStatement.setInt(7, product.getId());
        preparedStatement.executeUpdate();

    }

    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        connection = databaseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("product.id");
            String name = resultSet.getString("product.name");
            double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            int categoryId = resultSet.getInt("category_id");
            String categoryName = resultSet.getString("c.name");
            Category category = new Category(categoryId, categoryName);
            Product product = new Product(id, name, price, quantity, color, description, category);
            products.add(product);
        }

        return products;

    }

    public void insertProduct(Product product) throws SQLException {
        connection = databaseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_STUDENT);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getDescription());
        preparedStatement.setInt(6, product.getCategory().getId());
        preparedStatement.executeUpdate();
    }

    public void insertProduct(Product product, int categoryId) {
        connection = databaseRepository.connectDataBase();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_STUDENT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
