package mobileconnection.menu;

import mobileconnection.command.Command;
import mobileconnection.command.companymenucommand.*;
import mobileconnection.tariff.Tariff;

import static mobileconnection.menu.MenuUtils.menuLoop;
import static mobileconnection.service.CompanyService.getCurrentCompany;

public class CompanyMenu {
    public static void callCompanyMenu(){
        menuLoop(createCompanyCommandArray(), "\n\t\t***Меню компанії \"" + getCurrentCompany().getName() + "\"***", "Ще немає тарифів...", 4);
    }

    public static Command[] createCompanyCommandArray() {
        Tariff[] tariffs = getCurrentCompany().getTariffs();
        Command[] commandArray = new Command[tariffs == null ? 4 : 7];
        int i = 0;

        if (tariffs != null)
            commandArray[i++] = new ChooseTariffCommand(tariffs);
        commandArray[i++] = new AddTariffCommand();
        if (tariffs != null) {
            commandArray[i++] = new SortTariffCommand();
            commandArray[i++] = new SearchTariffCommand();
        }
        commandArray[i++] = new PrintUsersNumberCommand();
        commandArray[i++] = new ChangeCompanyCommand();
        commandArray[i] = new DeleteCompanyCommand();

        return commandArray;
    }
}
