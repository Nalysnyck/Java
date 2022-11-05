package com.mobileconnection.command.companymenucommand;

import com.mobileconnection.command.Command;
import com.mobileconnection.mobilecompany.MobileCompany;

import static com.mobileconnection.service.CompanyService.getCurrentCompany;

public class PrintUsersNumberCommand implements Command {
    private MobileCompany currentCompany;
    @Override
    public void execute() {
        System.out.println("\nКількість користувачів компанії \"" + currentCompany.getName() + "\": " + currentCompany.getUsersNumber() + '\n');
    }

    public PrintUsersNumberCommand(){
        this.currentCompany = getCurrentCompany();
    }

    public String toString(){
        return "Вивести кількість користувачів компанії";
    }
}