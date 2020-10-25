package com.project.management.services;

import com.project.management.console.View;
import com.project.management.domain.Company;
import com.project.management.domainDAO.CompanyDAO;
import com.project.management.domainDAO.DataCRUD;

import java.sql.SQLException;


import static com.project.management.services.InputValidator.validateString;

public class CompanyService {

    private final View view;
    private DataCRUD<Company> CompanyDAO;

    public CompanyService(View view) {
        CompanyDAO = new CompanyDAO();
        this.view = view;
    }

    public void inputCompany() {
        Company company = enterPositionCompany();
        try {
            CompanyDAO.create(company);
        } catch (SQLException e) {
            view.write("Can't create  company with name -- " + company.getName() + "  " + e.getMessage());
        }
    }

    public void readCompany() throws SQLException {
        view.write("Out Companies in format NAME \n" +
                "Country");
        CompanyDAO.read();
    }

    public Company enterPositionCompany() {
        view.write("Enter Company name");
        String name = validateString(view);
        view.write("Enter Company country from");
        String country = validateString(view);
        return (new Company(name, country));
    }

    public void updateCompany() {
        Company company = enterPositionCompany();
        try {
            CompanyDAO.update(company);
        } catch (SQLException e) {
            view.write("Can't update  company with name -- " + company.getName() + "  " + e.getMessage());
        }
    }

    public void deleteCompany() {
        view.write("Enter Company name");
        String name = validateString(view);
        try {
            CompanyDAO.delete(name);
        } catch (SQLException e) {
            view.write("Can't delete  company with name -- " + name + "  " + e.getMessage());
        }
    }


}
