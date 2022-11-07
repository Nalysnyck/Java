package com.mobileconnection.menu;

import com.mobileconnection.command.Command;
import com.mobileconnection.command.mainmenucommand.AddCompanyCommand;
import com.mobileconnection.command.mainmenucommand.ChooseCompanyCommand;
import com.mobileconnection.mobilecompany.MobileCompany;

import static com.mobileconnection.service.CompanyService.getCompanyArray;

public class MainMenu extends Menu {
    public void execute() {
        this.menuLoop(createCommandArray(getCompanyArray()), 1);
    }

    public Command[] createCommandArray(MobileCompany[] companies) {
        if (companies == null)
            return new Command[]{ new AddCompanyCommand() };
        else
            return new Command[]{ new ChooseCompanyCommand(), new AddCompanyCommand() };
    }

    protected String getMessage1(){return "\n\t\t***Головне меню***";}
    protected String getMessage2(){return "Ще немає компаній...";}
}
