package mobileconnection.command.companymenucommand;

import mobileconnection.command.Command;
import mobileconnection.menu.CompanyMenu;
import mobileconnection.mobilecompany.MobileCompany;

import static mobileconnection.Main.IN;
import static mobileconnection.menu.Menu.setCommands;
import static mobileconnection.service.CompanyService.*;

public class ChangeCompanyCommand implements Command {
    @Override
    public void execute() {
        System.out.println("\nПоточна назва компанії: " + getCurrentCompany().getName());
        System.out.print("Введіть нову назву компанії: ");
        MobileCompany company = getCurrentCompany();
        String oldName = company.getName();
        company.setName(IN.nextLine());
        overwriteCompany(company, oldName);
        setCurrentCompany(company);

        setCommands(CompanyMenu.createCommandArray());
    }

    @Override
    public String toString() {
        return "Змінити назву компанії";
    }
}
