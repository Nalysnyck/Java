package mobileconnection.menu;

import mobileconnection.command.Command;
import mobileconnection.command.mainmenucommand.AddCompanyCommand;
import mobileconnection.command.mainmenucommand.ChooseCompanyCommand;

import static mobileconnection.menu.MenuUtils.menuLoop;
import static mobileconnection.service.CompanyService.getCompanyArray;


public class MainMenu {
    public static void callMainMenu() {
        menuLoop(createMainCommandArray(), "\n\t\t***Головне меню***", "Ще немає компаній...", 1);
    }

    public static Command[] createMainCommandArray(){
        if (getCompanyArray() == null)
            return new Command[]{ new AddCompanyCommand() };
        else
            return new Command[]{ new ChooseCompanyCommand(), new AddCompanyCommand() };
    }
}
