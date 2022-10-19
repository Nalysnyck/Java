package mobileconnection.command.tariffmenucommand;

import mobileconnection.command.Command;
import mobileconnection.mobilecompany.MobileCompany;

import static mobileconnection.menu.MenuUtils.setCommands;
import static mobileconnection.menu.TariffMenu.createTariffCommandArray;
import static mobileconnection.service.CompanyService.*;

public class DeleteTariffCommand implements Command {
    @Override
    public void execute() {
        MobileCompany company = getCurrentCompany();
        company.deleteTariff(getCurrentTariff());
        overwriteCompany(company, company.getName());

        setCommands(createTariffCommandArray());
    }

    @Override
    public String toString() {
        return "Видалити тариф";
    }
}
