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
    private final static String READ = "SELECT  * FROM customers;";
    private final static String INSERT = "INSERT INTO customers  (name,email)VALUES (?,?);";
    private final static String UPDATE = "UPDATE customers set email=? where name=?;";
    private final static String DELETE = "DELETE FROM customers WHERE name=? ";


    @Override
    public void create(Customer customer) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            LOGGER.debug("Create customer : customer.name%s " + customer.getName());
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.execute();
            System.out.println("Customer  " + customer.toString() + "  was created");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to Create customer : customer.name%s " + customer.getName());
            System.out.println("Fail to create Customer " + e.getMessage());
        }
    }


    @Override
    public void read() {
        OutPutValidator.writeOUT(READ);
    }

    @Override
    public void update(Customer customer) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            LOGGER.debug("Update customer : customer.name%s " + customer.getName());
            statement.setString(1, customer.getEmail());
            statement.setString(2, customer.getName());
            statement.execute();
            System.out.println("Customer  " + customer.toString() + "  was updated");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to Update customer : customer.name%s " + customer.getName());
            System.out.println("Fail to update Customer " + e.getMessage());
        }
    }

    @Override
    public void delete(String name) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            LOGGER.debug("delete customer : customer.name%s " + name);
            statement.setString(1, name);
            statement.execute();
            System.out.println("Customer  " + name + "  was deleted");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to delete customer : customer.name%s " + name);
            System.out.println("Fail to delete customer " + e.getMessage());
        }
    }
}

