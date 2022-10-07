package mobileconnection.menu;

import mobileconnection.command.Command;
import mobileconnection.command.companycommand.AddCompanyCommand;
import mobileconnection.command.companycommand.ChooseCompanyCommand;
import mobileconnection.mobilecompany.MobileCompany;

import static mobileconnection.menu.MenuUtils.menuLoop;
import static mobileconnection.service.CompanyService.getCompanyArray;


public class MainMenu {
    public static void callMainMenu() {
        menuLoop(createMainCommandArray(), "\t\tМеню компаній", "Ще немає компаній...", 1);
    }

    private static Command[] createMainCommandArray(){
        MobileCompany[] companies = getCompanyArray();
        if (companies == null)
            return new Command[]{ new AddCompanyCommand() };
        else
            return new Command[]{ new ChooseCompanyCommand(companies), new AddCompanyCommand() };
    }
}
