package com.mobileconnection.command.companymenucommand;

import com.mobileconnection.command.Command;
import com.mobileconnection.menu.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mobileconnection.Main.IN;
import static com.mobileconnection.menu.Menu.setCommands;
import static com.mobileconnection.service.CompanyService.*;

public class DeleteCompanyCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(DeleteCompanyCommand.class);
    @Override
    public void execute() {
        int choice;
        try {
            System.out.print("\nБажаєте видалити мобільну компанію \"" + getCurrentCompany().getName() + "\"?"
                    + "\n\t1. Так"
                    + "\n\t2. Ні"
                    + "\nВаш вибір >>> ");
            choice = Integer.parseInt(IN.nextLine());
        } catch (Exception e) {
            logger.error("Введено некоректне значення!", e);
            choice = -1;
        }
        if (choice == 1) {
            logger.info("Видалено компанію \"" + getCurrentCompany().getName() + "\"");
            deleteCompany(getCurrentCompany());
        }

        MainMenu mainMenu = new MainMenu();
        setCommands(mainMenu.createCommandArray(getCompanyArray()));
    }

    public String toString(){
        return "Видалити мобільну компанію";
    }
}
