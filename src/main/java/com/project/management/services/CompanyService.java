package com.project.management.services;

import com.project.management.console.View;
import com.project.management.domain.Company;
import com.project.management.domainDAO.CompanyDAO;
import com.project.management.domainDAO.DataCRUD;

import java.time.LocalDate;

public class CompanyService {
    private  final View view;
    private DataCRUD<Company>CompanyDAO;

    public CompanyService(View view) {
        CompanyDAO =new CompanyDAO();
        this.view = view;
    }

    public void  inputCompany(){
        view.write("Enter Company name");
        String name = view.read();
        view.write("Enter deadLIne date in format YYYY-MM-DD");
       // LocalDate deadLine =(LocalDate) view.read();
    }
}
