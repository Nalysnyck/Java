package com.mobileconnection.command.companymenucommand;

import com.mobileconnection.MyLogger;
import com.mobileconnection.command.Command;
import com.mobileconnection.menu.MainMenu;

import static com.mobileconnection.Main.IN;
import static com.mobileconnection.menu.Menu.setCommands;
import static com.mobileconnection.service.CompanyService.*;

public class DeleteCompanyCommand implements Command {
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
            MyLogger.logger.severe("Введено некоректне значення!");
            choice = -1;
        }
        if (choice == 1) {
            MyLogger.logger.info("Видалено компанію \"" + getCurrentCompany().getName() + "\"");
            deleteCompany(getCurrentCompany());
        }

        MainMenu mainMenu = new MainMenu();
        setCommands(mainMenu.createCommandArray(getCompanyArray()));
    }

    public String toString(){
        return "Видалити мобільну компанію";
    }
}
