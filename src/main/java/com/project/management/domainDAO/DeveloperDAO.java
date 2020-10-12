package com.project.management.domainDAO;

import com.project.management.database.DataBaseConnector;

import com.project.management.domain.Developer;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


    public class DeveloperDAO extends DataCRUD<Developer> {

        private HikariDataSource connector= DataBaseConnector.getConnector();

        private final static String INSERT = "INSERT INTO developers  (name,salary, sex,age) "+"VALUES (?,?,?,?)";

        @Override
        public void create(Developer developer) {
            try (Connection connection = connector.getConnection();
                 PreparedStatement statement = connection.prepareStatement(INSERT)){
                statement.setString(1,developer.getName());
                statement.setInt(2,developer.getSalary());
                statement.setString(3,developer.getSex());
                statement.setInt(4,developer.getAge());
                statement.execute();
                System.out.println("Developer" + developer.toString() + "was created");
            } catch (SQLException e) {
                System.out.println("Fail when create Developer " + e.getMessage());
            }
        }

        @Override
        public void read(Developer developer) {

        }

        @Override
        public void update(Developer developer) {

        }

        @Override
        public void delete(Developer developer) {

        }
    }
