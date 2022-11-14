package com.mobileconnection.command.companymenucommand;

import com.mobileconnection.command.Command;
import com.mobileconnection.mobilecompany.MobileCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mobileconnection.service.CompanyService.getCurrentCompany;

public class PrintUsersNumberCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(PrintUsersNumberCommand.class);
    private MobileCompany currentCompany;
    @Override
    public void execute() {
        logger.info("Виклик команди виведення кількості користувачів");
        System.out.println("\nКількість користувачів компанії \"" + currentCompany.getName() + "\": " + currentCompany.getUsersNumber() + '\n');
    }

    public PrintUsersNumberCommand(){
        this.currentCompany = getCurrentCompany();
    }

    public String toString(){
        return "Вивести кількість користувачів компанії";
    }
}