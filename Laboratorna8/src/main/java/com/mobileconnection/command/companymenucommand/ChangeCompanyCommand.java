package com.mobileconnection.command.companymenucommand;

import com.mobileconnection.command.Command;
import com.mobileconnection.menu.CompanyMenu;
import com.mobileconnection.mobilecompany.MobileCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mobileconnection.Main.IN;
import static com.mobileconnection.menu.Menu.setCommands;
import static com.mobileconnection.service.CompanyService.*;

public class ChangeCompanyCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(ChangeCompanyCommand.class);
    @Override
    public void execute() {
        System.out.println("\nПоточна назва компанії: " + getCurrentCompany().getName());
        System.out.print("Введіть нову назву компанії: ");
        MobileCompany company = getCurrentCompany();
        String oldName = company.getName();
        company.setName(IN.nextLine());
        overwriteCompany(company, oldName);
        setCurrentCompany(company);
        logger.info("Назва компанії \"" + oldName + "\" змінена на \"" + company.getName() + "\"");

        CompanyMenu companyMenu = new CompanyMenu();
        setCommands(companyMenu.createCommandArray(getCurrentCompany()));
    }

    @Override
    public String toString() {
        return "Змінити назву компанії";
    }
}
