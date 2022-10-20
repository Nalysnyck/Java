package mobileconnection.command.mainmenucommand;

import mobileconnection.command.Command;
import mobileconnection.menu.MainMenu;
import mobileconnection.mobilecompany.MobileCompany;

import static mobileconnection.menu.Menu.setCommands;
import static mobileconnection.service.CompanyService.addCompany;

public class AddCompanyCommand implements Command {
    @Override
    public void execute() {
        addCompany(new MobileCompany());
        setCommands(MainMenu.createCommandArray());
    }

    public String toString(){
        return "Створити мобільну компанію";
    }
}
