package com.project.management.services;

import com.project.management.console.View;
import com.project.management.domain.Company;
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
      Customer customer=  enterPositionCustomer();
        try {
            CustomerDAO.create(customer);
        } catch (SQLException e) {
            view.write("Can't create  customer with name -- " + customer.getName() + "  " + e.getMessage());
        }
    }


    public void readCustomer() throws SQLException {
        view.write("Out Customers in format NAME \n" +
                "email");
        CustomerDAO.read();
    }

    public Customer enterPositionCustomer(){
        view.write("Enter Customer name");
        String name = validateString(view);
        view.write("Enter  Customer email");
        String email = validateString(view);
        return   (new Customer(name, email));
    }

    public void updateCustomer(){
       Customer customer=enterPositionCustomer();
        try {
           CustomerDAO.update(customer);
        } catch (SQLException e) {
            view.write("Can't update  customer with name -- " + customer.getName() + "  " + e.getMessage());
        }
    }

    public void deleteCustomer() {
        view.write("Enter Customer name");
        String name = validateString(view);
        try {
            CustomerDAO.delete(name);
        } catch (SQLException e) {
            view.write("Can't delete  customer with name -- " + name + "  " + e.getMessage());
        }
    }
}


