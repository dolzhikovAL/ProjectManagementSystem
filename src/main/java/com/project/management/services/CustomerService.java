package com.project.management.services;

import com.project.management.console.View;
import com.project.management.domain.Customer;
import com.project.management.domainDAO.CustomerDAO;
import com.project.management.domainDAO.DataCRUD;

import java.sql.SQLException;

import static com.project.management.services.InputValidator.validateString;

public class CustomerService {

    private final View view;
    private DataCRUD<Customer> CustomerDAO;

    public CustomerService(View view) {
        this.view = view;
        CustomerDAO = new CustomerDAO();
    }


    public void inputCustomer() {

        view.write("Enter Customer name");
        String name = validateString(view);
        view.write("Enter  Customer email");
        String email = validateString(view);
        Customer customer = new Customer(name, email);
        try {
            CustomerDAO.create(customer);
        } catch (SQLException e) {
            view.write("Can't create  customer with name -- " + name + "  " + e.getMessage());
        }
    }


    public void readCustomer() throws SQLException {
        view.write("Out Customers in format NAME \n" +
                "email");
        CustomerDAO.read();
    }
}


