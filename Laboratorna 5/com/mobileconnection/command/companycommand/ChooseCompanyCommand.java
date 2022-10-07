package mobileconnection.command.companycommand;

import mobileconnection.command.Command;
import mobileconnection.mobilecompany.MobileCompany;

import static mobileconnection.menu.MenuUtils.IN;
import static mobileconnection.menu.TariffMenu.callTariffMenu;

public class ChooseCompanyCommand implements Command {
    private final MobileCompany[] companies;
    @Override
    public void execute() {
        int choice;

        while (true) {
            System.out.println("\t\t***Список компаній***:");
            for (int i = 0; i < companies.length; i++)
                System.out.println("[" + i + "] - " + companies[i]);
            System.out.println("[-1] - Вийти");

            try {
                System.out.print("Ваш вибір >>> ");
                choice = IN.nextInt();
            } catch (Exception e) {
                IN.nextLine();
                choice = -2;
            }

            if (choice == -1)
                break;
            if (choice > -1 && choice < companies.length)
                callTariffMenu(companies[choice]);
        }
    }

    public ChooseCompanyCommand(MobileCompany[] companies){
        this.companies = companies;
    }

    public String toString(){
        return "Вивести список мобільних компаній";
    }
}
