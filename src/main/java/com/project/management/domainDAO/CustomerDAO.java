package com.project.management.domainDAO;

import com.project.management.database.DataBaseConnector;
import com.project.management.domain.Customer;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO extends DataCRUD<Customer> {

    private HikariDataSource connector = DataBaseConnector.getConnector();
    private static final Logger LOGGER = LogManager.getLogger(CustomerDAO.class);

    private final static String INSERT = "INSERT INTO customers  (name,email)" + "VALUES (?,?)";

    @Override
    public void create(Customer customer) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            LOGGER.debug("Create customer : customer.name%s " + customer.getName());
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.execute();
            System.out.println("Customer" + customer.toString() + "  was created");
        } catch (SQLException e) {
            LOGGER.error(String.valueOf(" FAIL to Create customer : customer.name%s " + customer.getName() ));
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
