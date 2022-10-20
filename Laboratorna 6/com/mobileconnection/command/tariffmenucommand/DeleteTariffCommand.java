package mobileconnection.command.tariffmenucommand;

import mobileconnection.command.Command;
import mobileconnection.menu.TariffMenu;
import mobileconnection.mobilecompany.MobileCompany;

import static mobileconnection.menu.Menu.setCommands;
import static mobileconnection.service.CompanyService.*;

public class DeleteTariffCommand implements Command {
    @Override
    public void execute() {
        MobileCompany company = getCurrentCompany();
        company.deleteTariff(getCurrentTariff());
        overwriteCompany(company, company.getName());

        setCommands(TariffMenu.createCommandArray());
    }

    @Override
    public String toString() {
        return "Видалити тариф";
    }
}
