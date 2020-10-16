package com.project.management.console;

import com.project.management.services.*;

import static com.project.management.services.InputValidator.validateString;

public class Controller {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void readOption() {
        view.write("Hello world \n" +
                "This is Project management system \n" +
                "Please tape one of the next command \n" +
                "For CRUD  function type (CRUD)");
        choseOfMainFunction(view.read());

    }

    public void choseOfMainFunction(String input) {
        switch (input) {
            case "CRUD": {
                view.write("Please tape one of the next command \n" +
                        "for create function type (create) \n" +
                        "for update function type (update) \n" +
                        "for delete function type (delete) \n" +
                        "for read function type (read) \n" +
                        "or exit for exit");
                choseCrudOption(view.read());
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
            default: {
                InputValidator.tableChoseAsk(view);
                optionCreateObjectMenu(validateString(view));
                break;
            }
        }
    }
}
