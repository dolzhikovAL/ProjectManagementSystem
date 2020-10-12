package com.project.management.domainDAO;

import com.project.management.database.DataBaseConnector;
import com.project.management.domain.Project;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectDAO  extends DataCRUD<Project> {

        private HikariDataSource connector= DataBaseConnector.getConnector();

        private final static String INSERT = "INSERT INTO projects  (name,dead_line) "+"VALUES (?,?)";

        @Override
        public void create(Project project) {
            try (Connection connection = connector.getConnection();
                 PreparedStatement statement = connection.prepareStatement(INSERT)){
                statement.setString(1, project.getName());
                statement.setDate(2, Date.valueOf(project.getDeadLine()));
                statement.execute();
                System.out.println("Project" + project.toString() + "was created");
            } catch (SQLException e) {
                System.out.println("Fail when create Project  " + e.getMessage());
            }
        }

    @Override
    public void read(Project project) {

    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void delete(Project project) {

    }


}
