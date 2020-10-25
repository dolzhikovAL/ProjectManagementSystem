package com.project.management.domainDAO;

import com.project.management.database.DataBaseConnector;

import com.project.management.domain.Developer;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeveloperDAO extends DataCRUD<Developer> {

    private final HikariDataSource connector = DataBaseConnector.getConnector();
    private static final Logger LOGGER = LogManager.getLogger(DeveloperDAO.class);
    private final static String READ = "SELECT  * FROM developers;";
    private final static String INSERT = "INSERT INTO developers(name,salary, sex,age)VALUES (?,?,?,?);";
    private final static String UPDATE = "UPDATE developers set salary=?,sex=?,age=?  WHERE name=?;";
    private final static String DELETE = "DELETE FROM developers WHERE name=? ";

    @Override
    public void create(Developer developer) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            LOGGER.debug("Create developer : developer.name%s " + developer.getName());
            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getSalary());
            statement.setString(3, developer.getSex());
            statement.setInt(4, developer.getAge());
            statement.execute();
            System.out.println("Developer  " + developer.toString() + "  was created");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to Create developer : developer.name%s " + developer.getName());
            System.out.println("Fail when create Developer " + e.getMessage());
        }
    }

    @Override
    public void read() {
        OutPutValidator.writeOUT(READ);
        ;
    }

    @Override
    public void update(Developer developer) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            LOGGER.debug("Update developer : developer.name%s " + developer.getName());
            statement.setString(4, developer.getName());
            statement.setInt(1, developer.getSalary());
            statement.setString(2, developer.getSex());
            statement.setInt(3, developer.getAge());
            statement.execute();
            System.out.println("Developer  " + developer.toString() + "  was updated");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to Update developer : developer.name%s " + developer.getName());
            System.out.println("Fail to update Developer " + e.getMessage());
        }
    }

    @Override
    public void delete(String name) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            LOGGER.debug("delete developer : developer.name%s " + name);
            statement.setString(1, name);
            statement.execute();
            System.out.println("Developer  " + name + "  was deleted");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to delete developer : customer.name%s " + name);
            System.out.println("Fail to delete developer " + e.getMessage());
        }
    }
}

