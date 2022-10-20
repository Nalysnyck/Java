package mobileconnection.menu;

import mobileconnection.command.Command;
import mobileconnection.command.mainmenucommand.AddCompanyCommand;
import mobileconnection.command.mainmenucommand.ChooseCompanyCommand;

import static mobileconnection.service.CompanyService.getCompanyArray;


public class MainMenu extends Menu {
    public MainMenu() {
        this.menuLoop(createCommandArray(), 1);
    }

    public static Command[] createCommandArray(){
        if (getCompanyArray() == null)
            return new Command[]{ new AddCompanyCommand() };
        else
            return new Command[]{ new ChooseCompanyCommand(), new AddCompanyCommand() };
    }

    protected String getMessage1(){return "\n\t\t***Головне меню***";}
    protected String getMessage2(){return "Ще немає компаній...";}
}
