package mobileconnection.command.companymenucommand;

import mobileconnection.command.Command;

import static mobileconnection.service.CompanyService.getCurrentCompany;

public class PrintUsersNumberCommand implements Command {
    @Override
    public void execute() {
        System.out.println("\nКількість користувачів компанії \"" + getCurrentCompany().getName() + "\": " + getCurrentCompany().getUsersNumber() + '\n');
    }

    public String toString(){
        return "Вивести кількість користувачів компанії";
    }
}