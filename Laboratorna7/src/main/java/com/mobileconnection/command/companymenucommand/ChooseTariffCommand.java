package com.mobileconnection.command.companymenucommand;

import com.mobileconnection.command.Command;
import com.mobileconnection.menu.CompanyMenu;
import com.mobileconnection.menu.TariffMenu;
import com.mobileconnection.tariff.Tariff;

import static com.mobileconnection.Main.IN;
import static com.mobileconnection.menu.Menu.setCommands;
import static com.mobileconnection.service.CompanyService.*;

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
                TariffMenu tariffMenu = new TariffMenu();
                tariffMenu.execute();
            }
        }

        CompanyMenu companyMenu = new CompanyMenu();
        setCommands(companyMenu.createCommandArray(getCurrentCompany()));
    }

    public ChooseTariffCommand(Tariff[] tariffs) {
        this.tariffs = tariffs;
    }

    @Override
    public String toString() {
        return "Вивести список тарифів";
    }
}
