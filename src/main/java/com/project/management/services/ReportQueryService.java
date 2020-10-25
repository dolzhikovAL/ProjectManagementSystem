package com.project.management.services;

import com.project.management.console.View;
import com.project.management.domainDAO.ReportsQueryDAO;

public class ReportQueryService {

    private final View view;

    public ReportQueryService(View view) {
        this.view = view;
    }

    public void reportCostOfProject() {
        view.write("Enter name of project to count sum of salary");
        ReportsQueryDAO reportsQueryDAO = new ReportsQueryDAO();
        reportsQueryDAO.costOfProject(InputValidator.validateString(view));
    }

    public void reportDevelopersOfProject() {
        view.write("Enter name of project to take list of developers ");
        ReportsQueryDAO reportsQueryDAO = new ReportsQueryDAO();
        reportsQueryDAO.developersOnProject(InputValidator.validateString(view));
    }

    public void reportByLanguage() {
        view.write("Enter name of project to take list of developers ");
        ReportsQueryDAO reportsQueryDAO = new ReportsQueryDAO();
        reportsQueryDAO.developersByLanguage(InputValidator.validateString(view));
    }

    public void reportByLevel() {
        view.write("Enter name of project to take list of developers ");
        ReportsQueryDAO reportsQueryDAO = new ReportsQueryDAO();
        reportsQueryDAO.developersByLevel(InputValidator.validateString(view));
    }

    public void reportListProjects() {
        view.write("Enter name of project to take list of developers ");
        ReportsQueryDAO reportsQueryDAO = new ReportsQueryDAO();
        reportsQueryDAO.listOfProjects();
    }


}
