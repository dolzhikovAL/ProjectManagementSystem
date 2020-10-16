package com.project.management.services;

import com.project.management.console.View;
import com.project.management.domain.Company;
import com.project.management.domain.Project;
import com.project.management.domainDAO.CompanyDAO;
import com.project.management.domainDAO.DataCRUD;
import com.project.management.domainDAO.ProjectDAO;

import java.sql.SQLException;
import java.time.LocalDate;

public class ProjectService {
    private final View view;
    private DataCRUD<Project> ProjectDAO;

    public ProjectService(View view) {
        ProjectDAO = new ProjectDAO();
        this.view = view;
    }

    public void inputProject() {
        view.write("Enter Project name");
        String name = view.read();
        view.write("Enter project deadLIne");
        LocalDate deadLine = InputValidator.validateSLocalDate(view);
        Project project = new Project(name, deadLine);
        try {
            ProjectDAO.create(project);
        } catch (SQLException e) {
            view.write("Can't create  project with name -- " + name + "  " + e.getMessage());
        }
    }


}
