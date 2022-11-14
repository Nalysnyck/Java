package com.mobileconnection.command.mainmenucommand;

import com.mobileconnection.command.Command;
import com.mobileconnection.menu.MainMenu;
import com.mobileconnection.mobilecompany.MobileCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mobileconnection.menu.Menu.setCommands;
import static com.mobileconnection.service.CompanyService.addCompany;
import static com.mobileconnection.service.CompanyService.getCompanyArray;

public class AddCompanyCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(AddCompanyCommand.class);
    @Override
    public void execute() {
        MainMenu mainMenu = new MainMenu();
        MobileCompany newMobileCompany = new MobileCompany();
        addCompany(newMobileCompany);
        setCommands(mainMenu.createCommandArray(getCompanyArray()));
        logger.info("Додано компанію \"" + newMobileCompany.getName() + "\"");
    }

    public String toString(){
        return "Створити мобільну компанію";
    }
}