package com.mobileconnection.menu;

import com.mobileconnection.command.Command;
import com.mobileconnection.command.companymenucommand.*;
import com.mobileconnection.mobilecompany.MobileCompany;
import com.mobileconnection.tariff.Tariff;

import static com.mobileconnection.service.CompanyService.getCurrentCompany;

public class CompanyMenu extends Menu {
    public void execute(){
        this.menuLoop(createCommandArray(getCurrentCompany()), 4);
    }

    public Command[] createCommandArray(MobileCompany company){
        Tariff[] tariffs = company.getTariffs();
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