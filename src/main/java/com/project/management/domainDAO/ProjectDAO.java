package com.project.management.domainDAO;

import com.project.management.database.DataBaseConnector;
import com.project.management.domain.Project;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectDAO extends DataCRUD<Project> {

    private final HikariDataSource connector = DataBaseConnector.getConnector();
    private static final Logger LOGGER = LogManager.getLogger(ProjectDAO.class);
    private final static String READ = "SELECT * FROM projects;";
    private final static String INSERT = "INSERT INTO projects  (name,dead_line)  VALUES (?,?)";
    private final static String UPDATE = "UPDATE projects set email=? where name=?;";
    private final static String DELETE = "DELETE FROM projects WHERE name=? ";


    @Override
    public void create(Project project) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            LOGGER.debug("Create project : project.name%s " + project.getName());
            statement.setString(1, project.getName());
            statement.setDate(2, Date.valueOf(project.getDeadLine()));
            statement.execute();
            System.out.println("Project   " + project.toString() + "  was created");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to Create project : project.name%s " + project.getName());

            System.out.println("Fail when create Project  " + e.getMessage());
        }
    }

    @Override
    public void read() {
        OutPutValidator.writeOUT(READ);
    }

    @Override
    public void update(Project project) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            LOGGER.debug("Create project : project.name%s " + project.getName());
            statement.setDate(1, Date.valueOf(project.getDeadLine()));
            statement.setString(2, project.getName());
            statement.execute();
            System.out.println("Project  " + project.toString() + "  was updated");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to Update project : project.name%s " + project.getName());
            System.out.println("Fail when Update Project  " + e.getMessage());
        }
    }

    @Override
    public void delete(String name) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            LOGGER.debug("delete project: project.name%s " + name);
            statement.setString(1, name);
            statement.execute();
            System.out.println("Project  " + name + "  was deleted");
        } catch (SQLException e) {
            LOGGER.error(" FAIL to delete project : project.name%s " + name);
            System.out.println("Fail to delete project " + e.getMessage());
        }
    }
}


