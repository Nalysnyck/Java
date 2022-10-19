package mobileconnection.command.mainmenucommand;

import mobileconnection.command.Command;
import mobileconnection.mobilecompany.MobileCompany;

import static mobileconnection.menu.MainMenu.createMainCommandArray;
import static mobileconnection.menu.MenuUtils.setCommands;
import static mobileconnection.service.CompanyService.addCompany;

public class AddCompanyCommand implements Command {
    @Override
    public void execute() {
        addCompany(new MobileCompany());
        setCommands(createMainCommandArray());
    }

    public String toString(){
        return "Створити мобільну компанію";
    }
}
