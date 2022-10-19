package mobileconnection.command.companymenucommand;

import mobileconnection.command.Command;
import mobileconnection.tariff.Tariff;

import static mobileconnection.menu.CompanyMenu.createCompanyCommandArray;
import static mobileconnection.menu.MenuUtils.IN;
import static mobileconnection.menu.MenuUtils.setCommands;
import static mobileconnection.menu.TariffMenu.callTariffMenu;
import static mobileconnection.service.CompanyService.*;

public class ChooseTariffCommand implements Command {
    private final Tariff[] tariffs;
    @Override
    public void execute() {
        int choice;

        while (true) {
            System.out.println("\n\t\t***Список тарифів***:");
            for (int i = 0; i < tariffs.length; i++)
                System.out.println("[" + (i + 1) + "] - " + tariffs[i].getName());
            System.out.println("[0] - Вийти");

            try {
                System.out.print("Ваш вибір >>> ");
                choice = IN.nextInt();
            } catch (Exception e) {
                IN.nextLine();
                choice = -2;
            }

            if (choice == 0)
                break;
            if (choice > 0 && choice <= tariffs.length) {
                setCurrentTariff(tariffs[choice - 1]);
                callTariffMenu();
            }
        }

        setCommands(createCompanyCommandArray());
    }

    public ChooseTariffCommand(Tariff[] tariffs) {
        this.tariffs = tariffs;
    }

    @Override
    public String toString() {
        return "Вивести список тарифів";
    }
}
