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
                "For reports function type (report) \n" +
                "For exit type(exit)");
        view.write("");
        choseOfMainFunction(view.read());
    }

    public void choseOfMainFunction(String input) {
        switch (input) {
            case "CRUD": {
                tableCrudAsk(view);
                choseCrudOption(validateString(view));
                askMainOption();
                break;
            }
            case "report": {
                reportChoseAsk(view);
                choseReportOption(validateString(view));
                askMainOption();
                break;
            }
            case "exit": {
                view.write("Goodbye!");
                System.exit(0);
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
                InputValidator.tableChoseAsk(view);
                optionCreateObjectMenu(validateString(view));
                askMainOption();
                break;
            }
            case "update": {
                InputValidator.tableChoseAsk(view);
                optionUpdateObjectMenu(validateString(view));
                askMainOption();
                break;
            }
            case "read": {
                tableChoseAsk(view);
                optionReadObjectMenu(validateString(view));
                askMainOption();
                break;
            }
            case "delete": {
                tableChoseAsk(view);
                optionDeleteObjectMenu(validateString(view));
                askMainOption();
                break;
            }
            case "exit": {
                view.write("Goodbye!!!");
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

    public void choseReportOption(String input) {
        switch (input) {
            case "cost": {
                ReportQueryService reportQueryService = new ReportQueryService(view);
                reportQueryService.reportCostOfProject();
                askMainOption();
                break;
            }
            case "devList": {
                ReportQueryService reportQueryService = new ReportQueryService(view);
                reportQueryService.reportDevelopersOfProject();
                askMainOption();
                break;

            }
            case "byLanguage": {
                ReportQueryService reportQueryService = new ReportQueryService(view);
                reportQueryService.reportByLanguage();
                askMainOption();
                break;
            }
            case "byLevel": {
                ReportQueryService reportQueryService = new ReportQueryService(view);
                reportQueryService.reportByLevel();
                askMainOption();
                break;
            }
            case "listProj": {
                ReportQueryService reportQueryService = new ReportQueryService(view);
                reportQueryService.reportListProjects();
                askMainOption();
                break;
            }
            case "exit": {
                view.write("Goodbye!!!!");
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
                view.write("Goodbye!!!!!!!!!!!");
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

    public void optionDeleteObjectMenu(String input) {
        switch (input) {
            case "company": {
                CompanyService companyService = new CompanyService(view);
                companyService.deleteCompany();
                askMainOption();
                break;
            }
            case "customer": {
                CustomerService customerService = new CustomerService(view);
                customerService.deleteCustomer();
                askMainOption();
                break;
            }
            case "developer": {
                DeveloperService developerService = new DeveloperService(view);
                developerService.deleteDeveloper();
                askMainOption();
                break;
            }
            case "project": {
                ProjectService projectService = new ProjectService(view);
                projectService.deleteProject();
                askMainOption();
                break;
            }
            case "exit": {
                view.write("Goodbye!!!!!!!!!!!!!!!!!!!!!!!");
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

    public void optionUpdateObjectMenu(String input) {
        switch (input) {
            case "company": {
                CompanyService companyService = new CompanyService(view);
                companyService.updateCompany();
                askMainOption();
                break;
            }
            case "customer": {
                CustomerService customerService = new CustomerService(view);
                customerService.updateCustomer();
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
                projectService.updateProject();
                askMainOption();
                break;
            }
            case "exit": {
                view.write("Goodbye!!!!!!-!");
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
            case "exit": {
                view.write("Goodbye!!!!!!-!");
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
