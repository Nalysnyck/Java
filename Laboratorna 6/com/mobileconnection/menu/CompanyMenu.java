package mobileconnection.menu;

import mobileconnection.command.Command;
import mobileconnection.command.companymenucommand.*;
import mobileconnection.tariff.Tariff;

import static mobileconnection.service.CompanyService.getCurrentCompany;

public class CompanyMenu extends Menu {
    public CompanyMenu(){
        this.menuLoop(createCommandArray(), 4);
    }

    public static Command[] createCommandArray() {
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

    protected String getMessage1(){return "\n\t\t***Меню компанії \"" + getCurrentCompany().getName() + "\"***";}
    protected String getMessage2(){return "Ще немає компаній...";}
}
