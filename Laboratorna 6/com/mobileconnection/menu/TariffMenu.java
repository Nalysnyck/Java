package mobileconnection.menu;

import mobileconnection.command.Command;
import mobileconnection.command.tariffmenucommand.ChangeTariffCommand;
import mobileconnection.command.tariffmenucommand.DeleteTariffCommand;

import static mobileconnection.menu.MenuUtils.menuLoop;
import static mobileconnection.service.CompanyService.getCurrentTariff;

public class TariffMenu {
    public static void callTariffMenu(){
        menuLoop(createTariffCommandArray(), "\n\t\t***Тариф \"" + getCurrentTariff().getName() + "\"***\n\n" + getCurrentTariff(), "", 1);
    }

    public static Command[] createTariffCommandArray() {
        return new Command[]{ new ChangeTariffCommand(), new DeleteTariffCommand() };
    }
}
