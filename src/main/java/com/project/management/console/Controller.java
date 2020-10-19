package com.project.management.console;

import com.project.management.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

import static com.project.management.services.InputValidator.*;

public class Controller {

    private final View view;
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    public Controller(View view) {
        this.view = view;
        LOGGER.trace("Start application");
    }

    public void askMainOption() {
        view.write("Hello world \n" +
                "This is Project management system \n" +
                "Please tape one of the next command \n" +
                "For CRUD  function type (CRUD) \n" +
                "For exit type(exit)");
        choseOfMainFunction(view.read());

    }

    public void choseOfMainFunction(String input) {
        switch (input) {

            case "CRUD": {
                tableCrudAsk(view);
                choseCrudOption(view.read());
                break;
            }
            case "report": {
                view.write("Please type what kind of report you need \n" +
                        "");
                break;
            }
            case "exit": {
                view.write("Goodbye!!!!!!!");
                break;
            }
            default: {
                view.write("Command  was incorrect \n" +
                        "try one more time to chose MAIN command");
                askMainOption();

            }
        }
    }

    public void choseCrudOption(String input) {


        switch (input) {
            case "create": {
                optionCreateObjectMenu(validateString(view));
                break;
            }
            case "update": {
                break;

            }
            case "read": {
                tableChoseAsk(view);
                optionReadObjectMenu(validateString(view));
                break;

            }
            case "delete": {
                System.out.println("2");
                break;
            }
            case "exit": {
                view.write("Goodbye!!!!!!!");
                break;
            }
            default: {
                view.write("Command was incorrect \n" +
                        "try one more time to chose CRUD command");
                InputValidator.tableCrudAsk(view);
                choseCrudOption(view.read());
                break;
            }
        }
    }

    public void optionCreateObjectMenu(String input) {
        switch (input) {
            case "company": {
                CompanyService companyService = new CompanyService(view);
                companyService.inputCompany();
                askMainOption();
                break;
            }
            case "customer": {
                CustomerService customerService = new CustomerService(view);
                customerService.inputCustomer();
                askMainOption();
                break;
            }
            case "developer": {
                DeveloperService developerService = new DeveloperService(view);
                developerService.inputDeveloper();
                askMainOption();
                break;
            }
            case "project": {
                ProjectService projectService = new ProjectService(view);
                projectService.inputProject();
                askMainOption();
                break;
            }
            case "exit": {
                view.write("Goodbye!!!!!!!");
                break;
            }
            default: {
                view.write("Wrong object-----");
                InputValidator.tableChoseAsk(view);
                optionCreateObjectMenu(validateString(view));

                break;
            }
        }
    }

    public void optionReadObjectMenu(String input) {
        switch (input) {
            case "customer": {
                CustomerService customerService = new CustomerService(view);
                try {
                    customerService.readCustomer();
                } catch (SQLException e) {
                    System.out.println("not good with read customer");
                    e.printStackTrace();
                }
                askMainOption();

                break;
            }
            case "company": {
                CompanyService companyService = new CompanyService(view);
                try {
                    companyService.readCompany();
                } catch (SQLException e) {
                    System.out.println("not good with read company ");
                    e.printStackTrace();
                }
                askMainOption();

                break;

            }
            case "project": {
                ProjectService projectService = new ProjectService(view);
                try {
                    projectService.readProject();
                } catch (SQLException e) {
                    System.out.println("not good with read project ");
                    e.printStackTrace();
                }
                askMainOption();

                break;
            }
            case "developer": {
                DeveloperService developerService = new DeveloperService(view);
                try {
                    developerService.readDeveloper();
                } catch (SQLException e) {
                    System.out.println("not good with read company ");
                    e.printStackTrace();
                }
                askMainOption();

                break;
            }
            default: {
                view.write("Command was incorrect \n" +
                        "try one more time");
                tableChoseAsk(view);
                optionReadObjectMenu(validateString(view));

            }
        }
    }
}
