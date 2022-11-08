package com.mobileconnection.command.tariffmenucommand;

import com.mobileconnection.MyLogger;
import com.mobileconnection.command.Command;
import com.mobileconnection.menu.TariffMenu;
import com.mobileconnection.mobilecompany.MobileCompany;

import static com.mobileconnection.menu.Menu.setCommands;
import static com.mobileconnection.service.CompanyService.*;

public class DeleteTariffCommand implements Command {
    @Override
    public void execute() {
        MobileCompany company = getCurrentCompany();
        MyLogger.logger.info("Тариф \"" + getCurrentTariff().getName() + "\" видалений із компанії \"" + company.getName() + "\"");
        company.deleteTariff(getCurrentTariff());
        overwriteCompany(company, company.getName());

        TariffMenu tariffMenu = new TariffMenu();
        setCommands(tariffMenu.createCommandArray());
    }

    @Override
    public String toString() {
        return "Видалити тариф";
    }
}
