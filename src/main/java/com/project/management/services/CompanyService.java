package com.project.management.services;

import com.project.management.console.View;
import com.project.management.domain.Company;
import com.project.management.domainDAO.CompanyDAO;
import com.project.management.domainDAO.DataCRUD;

import java.sql.SQLException;


import static com.project.management.services.InputValidator.validateString;

public class CompanyService {
    private  final View view;
    private DataCRUD<Company> CompanyDAO;

    public CompanyService(View view) {
        CompanyDAO =new CompanyDAO();
        this.view = view;
    }

    public void inputCompany() {
        view.write("Enter Company name");
        String name = validateString(view);
        view.write("Enter Company country from");
        String country = validateString(view);
        Company company = new Company(name, country);
        try {
            CompanyDAO.create(company);
        } catch (SQLException e) {
            view.write("Can't create  company with name -- " + name + "  " + e.getMessage());
        }
    }
}
