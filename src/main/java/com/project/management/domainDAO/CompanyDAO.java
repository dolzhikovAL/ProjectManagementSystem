package com.project.management.domainDAO;

import com.project.management.database.DataBaseConnector;
import com.project.management.domain.Company;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class CompanyDAO extends DataCRUD<Company> {

    private HikariDataSource connector= DataBaseConnector.getConnector();

    private final static String INSERT = "INSERT INTO companies(name,country)" + "VALUES (?,?)";

    @Override
    public void create(Company company) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setString(1,company.getName());
            statement.setString(2,company.getCountry());
            statement.execute();
            System.out.println("Company" + company.toString() + "was created");
        } catch (SQLException e) {
            System.out.println("Fail to create company ");
        }
    }

    @Override
    public void read(Company company) {

    }

    @Override
    public void update(Company company) {

    }

    @Override
    public void delete(Company company) {

    }

}
