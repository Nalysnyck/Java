package mobileconnection.menu;

import mobileconnection.command.Command;
import mobileconnection.command.companycommand.DeleteCompanyCommand;
import mobileconnection.command.companycommand.PrintUsersNumberCommand;
import mobileconnection.command.tariffcommand.AddTariffCommand;
import mobileconnection.command.tariffcommand.ChooseTariffCommand;
import mobileconnection.command.tariffcommand.SortTariffCommand;
import mobileconnection.command.tariffcommand.searchtariffcommand.SearchTariffByCostCommand;
import mobileconnection.mobilecompany.MobileCompany;
import mobileconnection.tariff.Tariff;

import static mobileconnection.menu.MenuUtils.printMenu;

public class TariffMenu {
    public static void callTariffMenu(MobileCompany company){
        printMenu(createTariffCommandArray(company), "\t\t***Меню тарифів компанії \"" + company.getName() + "\"***\n\tСписок тарифів:", "Ще немає тарифів...", 3);
    }

    private static Command[] createTariffCommandArray(MobileCompany company) {
        Tariff[] tariffs = company.getTariffs();
        Command[] commandArray = new Command[tariffs == null ? 3 : 6];
        int i = 0;

        if (tariffs != null)
            commandArray[i++] = new ChooseTariffCommand(tariffs);
        commandArray[i++] = new AddTariffCommand();
        if (tariffs != null) {
            commandArray[i++] = new SortTariffCommand(company);
            commandArray[i++] = new SearchTariffByCostCommand();
        }
        commandArray[i++] = new PrintUsersNumberCommand();
        commandArray[i] = new DeleteCompanyCommand();

        return commandArray;
    }
}
