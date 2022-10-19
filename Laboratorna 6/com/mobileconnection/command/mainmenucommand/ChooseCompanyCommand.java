package mobileconnection.command.mainmenucommand;

import mobileconnection.command.Command;
import mobileconnection.mobilecompany.MobileCompany;

import static mobileconnection.menu.MainMenu.createMainCommandArray;
import static mobileconnection.menu.MenuUtils.IN;
import static mobileconnection.menu.CompanyMenu.callCompanyMenu;
import static mobileconnection.menu.MenuUtils.setCommands;
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
                callCompanyMenu();
                companies = getCompanyArray();
            }
        }
        setCommands(createMainCommandArray());
    }

    public String toString(){
        return "Вивести список мобільних компаній";
    }
}
