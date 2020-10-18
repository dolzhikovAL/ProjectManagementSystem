package com.project.management.console;

import com.project.management.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.project.management.services.InputValidator.tableCrudAsk;
import static com.project.management.services.InputValidator.validateString;

public class Controller {

    private View view;
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    public Controller(View view) {
        this.view = view;
        LOGGER.trace("Start application");
    }

    public void readOption() {
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
                view.write("Command was incorrect \n" +
                        "try one more time");
                readOption();
                break;
            }
        }
    }

    public void choseCrudOption(String input) {
        switch (input) {
            case "create": {
                InputValidator.tableChoseAsk(view);
                optionCreateObjectMenu(validateString(view));
                break;
            }
            case "update": {
                InputValidator.tableChoseAsk(view);


            }
            case "read": {
                InputValidator.tableChoseAsk(view);


            }
            case "delete": {
                InputValidator.tableChoseAsk(view);
            }
            case "exit": {
                view.write("Goodbye!!!!!!!");
                break;
            }
            default: {
                view.write("Command was incorrect \n" +
                        "try one more time");
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
                readOption();
                break;
            }
            case "customer": {
                CustomerService customerService = new CustomerService(view);
                customerService.inputCustomer();
                readOption();
                break;
            }
            case "developer": {
                DeveloperService developerService = new DeveloperService(view);
                developerService.inputDeveloper();
                readOption();
                break;
            }
            case "project": {
                ProjectService projectService = new ProjectService(view);
                projectService.inputProject();
                readOption();
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
}
