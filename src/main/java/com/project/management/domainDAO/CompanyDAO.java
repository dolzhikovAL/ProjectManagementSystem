package com.project.management.domainDAO;

import com.project.management.database.DataBaseConnector;
import com.project.management.domain.Company;
import com.project.management.services.InputValidator;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CompanyDAO extends DataCRUD<Company> {

    private static final HikariDataSource connector = DataBaseConnector.getConnector();
    private static final Logger LOGGER = LogManager.getLogger(CompanyDAO.class);
    private final static String INSERT = "INSERT INTO companies(name,country)" + "VALUES (?,?)";
    private final static String READ = "SELECT  * FROM companies";

    @Override
    public void create(Company company) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            LOGGER.debug("Create company : company.name%s " + company.getName());

            statement.setString(1, company.getName());
            statement.setString(2, company.getCountry());
            statement.execute();
            System.out.println("Company" + company.toString() + "  was created");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to Create company : company.name%s " + company.getName());
            System.out.println("Fail to create company " + e.getMessage());
        }
    }

    @Override
    public void read() {
        InputValidator.writeOUT(READ);
    }

    @Override
    public void update(Company company) {

    }

    @Override
    public void delete(Company company) {

    }

}
