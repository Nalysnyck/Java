package com.mobileconnection.command.tariffmenucommand;

import com.mobileconnection.command.Command;
import com.mobileconnection.menu.TariffMenu;
import com.mobileconnection.mobilecompany.MobileCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mobileconnection.menu.Menu.setCommands;
import static com.mobileconnection.service.CompanyService.*;

public class DeleteTariffCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(DeleteTariffCommand.class);
    @Override
    public void execute() {
        MobileCompany company = getCurrentCompany();
        logger.info("Тариф \"" + getCurrentTariff().getName() + "\" видалений із компанії \"" + company.getName() + "\"");
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
