package com.project.management.domainDAO;

import com.project.management.database.DataBaseConnector;
import com.project.management.domain.Customer;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO extends DataCRUD<Customer> {

    private HikariDataSource  connector= DataBaseConnector.getConnector();


    private final static String INSERT = "INSERT INTO customers  (name,email)"+"VALUES (?,?)";

    @Override
    public void create(Customer customer) {
        try (Connection connection = connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setString(1,customer.getName());
            statement.setString(2,customer.getEmail());
            statement.execute();
            System.out.println("Customer" + customer.toString() + "was created");
        } catch (SQLException e) {
            System.out.println("Fail to create Customer " + e.getMessage());
        }
    }


    @Override
    public void read(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
