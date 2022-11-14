package com.mobileconnection.command.mainmenucommand;

import com.mobileconnection.command.Command;
import com.mobileconnection.menu.CompanyMenu;
import com.mobileconnection.menu.MainMenu;
import com.mobileconnection.mobilecompany.MobileCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mobileconnection.Main.IN;
import static com.mobileconnection.menu.Menu.setCommands;
import static com.mobileconnection.service.CompanyService.getCompanyArray;
import static com.mobileconnection.service.CompanyService.setCurrentCompany;

public class ChooseCompanyCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(ChooseCompanyCommand.class);
    @Override
    public void execute() {
        MobileCompany[] companies = getCompanyArray();
        int choice;

        while (true) {
            System.out.println("\n\t\t***Список компаній***:");
            if (companies == null) {
                logger.info("Масив компаній пустий");
                break;
            }
            if (companies.length == 0) {
                logger.info("Масив компаній пустий");
                break;
            }
            for (int i = 0; i < companies.length; i++)
                System.out.println("[" + (i + 1) + "] - " + companies[i].getName());
            System.out.println("[0] - Вийти");

            try {
                System.out.print("Ваш вибір >>> ");
                choice = Integer.parseInt(IN.nextLine());
            } catch (Exception e) {
                choice = -1;
                logger.error("Некоректний ввід!", e);
            }

            if (choice == 0)
                break;
            if (choice > 0 && choice <= companies.length) {
                setCurrentCompany(companies[choice  - 1]);
                logger.info("Вибрана компанія: " + companies[choice - 1].getName());
                CompanyMenu companyMenu = new CompanyMenu();
                companyMenu.execute();
                companies = getCompanyArray();
            }
        }
        MainMenu mainMenu = new MainMenu();
        setCommands(mainMenu.createCommandArray(getCompanyArray()));
    }

    public String toString(){
        return "Вивести список мобільних компаній";
    }
}
