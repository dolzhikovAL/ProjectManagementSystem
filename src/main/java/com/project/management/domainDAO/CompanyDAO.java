package com.project.management.domainDAO;

import com.project.management.database.DataBaseConnector;
import com.project.management.domain.Company;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CompanyDAO extends DataCRUD<Company> {

    private final HikariDataSource connector = DataBaseConnector.getConnector();
    private static final Logger LOGGER = LogManager.getLogger(CompanyDAO.class);
    private final static String INSERT = "INSERT INTO companies(name,country)VALUES (?,?);";
    private final static String READ = "SELECT  * FROM companies;";
    private final static String UPDATE = "UPDATE companies set country=? WHERE name=?;";
    private final static String DELETE = "DELETE FROM companies WHERE name=? ";

    @Override
    public void create(Company company) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            LOGGER.debug("Create company : company.name%s " + company.getName());
            statement.setString(1, company.getName());
            statement.setString(2, company.getCountry());
            statement.execute();
            System.out.println("Company  " + company.toString() + "  was created");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to Create company : company.name%s " + company.getName());
            System.out.println("Fail to create company " + e.getMessage());
        }
    }

    @Override
    public void read() {
        OutPutValidator.writeOUT(READ);
    }

    @Override
    public void update(Company company) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            LOGGER.debug("Update company : company.name%s " + company.getName());
            statement.setString(1, company.getCountry());
            statement.setString(2, company.getName());
            statement.execute();
            System.out.println("Company  " + company.toString() + "  was updated");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to update company : company.name%s " + company.getName());
            System.out.println("Fail to update company " + e.getMessage());
        }
    }

    @Override
    public void delete(String name) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            LOGGER.debug("Delete company : company.name%s " + name);
            statement.setString(1, name);
            statement.execute();
            System.out.println("Company  " + name + "  was deleted");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to delete company : company.name%s " + name);
            System.out.println("Fail to delete company " + e.getMessage());
        }
    }
}
