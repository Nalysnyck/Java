package mobileconnection.command.mainmenucommand;

import mobileconnection.command.Command;
import mobileconnection.menu.CompanyMenu;
import mobileconnection.menu.MainMenu;
import mobileconnection.mobilecompany.MobileCompany;

import static mobileconnection.Main.IN;
import static mobileconnection.menu.Menu.setCommands;
import static mobileconnection.service.CompanyService.getCompanyArray;
import static mobileconnection.service.CompanyService.setCurrentCompany;

public class ChooseCompanyCommand implements Command {
    @Override
    public void execute() {
        MobileCompany[] companies = getCompanyArray();
        int choice;

        while (true) {
            System.out.println("\n\t\t***Список компаній***:");
            for (int i = 0; i < companies.length; i++)
                System.out.println("[" + (i + 1) + "] - " + companies[i].getName());
            System.out.println("[0] - Вийти");

            try {
                System.out.print("Ваш вибір >>> ");
                choice = IN.nextInt();
            } catch (Exception e) {
                IN.nextLine();
                choice = -1;
            }

            if (choice == 0)
                break;
            if (choice > 0 && choice <= companies.length) {
                setCurrentCompany(companies[choice  - 1]);
                new CompanyMenu();
                companies = getCompanyArray();
            }
        }
        setCommands(MainMenu.createCommandArray());
    }

    public String toString(){
        return "Вивести список мобільних компаній";
    }
}
