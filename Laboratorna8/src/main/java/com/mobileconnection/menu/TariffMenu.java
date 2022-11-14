package com.mobileconnection.menu;

import com.mobileconnection.command.Command;
import com.mobileconnection.command.tariffmenucommand.ChangeTariffCommand;
import com.mobileconnection.command.tariffmenucommand.DeleteTariffCommand;

import static com.mobileconnection.service.CompanyService.getCurrentTariff;

public class TariffMenu extends Menu {
    public void execute(){
        this.menuLoop(createCommandArray(), 1);
    }

    public Command[] createCommandArray() {
        return new Command[]{ new ChangeTariffCommand(), new DeleteTariffCommand() };
    }

    protected String getMessage1(){return "" + getCurrentTariff();}
    protected String getMessage2(){return "";}
}
