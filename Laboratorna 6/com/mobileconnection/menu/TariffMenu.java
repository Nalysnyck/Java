package mobileconnection.menu;

import mobileconnection.command.Command;
import mobileconnection.command.tariffmenucommand.ChangeTariffCommand;
import mobileconnection.command.tariffmenucommand.DeleteTariffCommand;

import static mobileconnection.service.CompanyService.getCurrentTariff;

public class TariffMenu extends Menu {
    public TariffMenu(){
        this.menuLoop(createCommandArray(), 1);
    }

    public static Command[] createCommandArray() {
        return new Command[]{ new ChangeTariffCommand(), new DeleteTariffCommand() };
    }

    protected String getMessage1(){return "" + getCurrentTariff();}
    protected String getMessage2(){return "";}
}
