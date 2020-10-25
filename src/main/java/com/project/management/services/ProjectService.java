package com.project.management.services;

import com.project.management.console.View;
import com.project.management.domain.Project;
import com.project.management.domainDAO.DataCRUD;
import com.project.management.domainDAO.ProjectDAO;
import java.sql.SQLException;
import java.time.LocalDate;

import static com.project.management.services.InputValidator.validateString;


public class ProjectService {

    private final View view;
    private final DataCRUD<Project> ProjectDAO;

    public ProjectService(View view) {
        this.view = view;
        ProjectDAO = new ProjectDAO();
    }

    public void inputProject() {
        Project project = enterPositionProject();
        try {
            ProjectDAO.create(project);
        } catch (SQLException e) {
            view.write("Can't create  project with name -- " + project.getName() + "  " + e.getMessage());
        }
    }

    public void readProject() throws SQLException {
        view.write("Out Project in format NAME \n" +
                "project deadline");
        ProjectDAO.read();
    }

    public Project enterPositionProject() {
        view.write("Enter Project name");
        String name = view.read();
        view.write("Enter project deadLIne");
        LocalDate deadLine = InputValidator.validateSLocalDate(view);
        return (new Project(name, deadLine));
    }

    public void updateProject() {
        Project project = enterPositionProject();
        try {
            ProjectDAO.update(project);
        } catch (SQLException e) {
            view.write("Can't update project with name -- " + project.getName() + "  " + e.getMessage());
        }
    }
    public void deleteProject() {
        view.write("Enter Project name");
        String name = validateString(view);
        try {
            ProjectDAO.delete(name);
        } catch (SQLException e) {
            view.write("Can't delete  project with name -- " + name + "  " + e.getMessage());
        }
    }
}



