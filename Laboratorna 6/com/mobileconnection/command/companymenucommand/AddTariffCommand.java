package mobileconnection.command.companymenucommand;

import mobileconnection.command.Command;
import mobileconnection.menu.CompanyMenu;
import mobileconnection.mobilecompany.MobileCompany;
import mobileconnection.tariff.Tariff;
import mobileconnection.tariff.TariffPackage;

import static mobileconnection.Main.IN;
import static mobileconnection.menu.Menu.setCommands;
import static mobileconnection.service.CompanyService.*;

public class AddTariffCommand implements Command {
    @Override
    public void execute() {
        MobileCompany company;
        int choice;
        do {
            System.out.println("\n\t\t***Створити тариф***:");
            System.out.println("[1] - Створити тариф");
            System.out.println("[2] - Створити пакет даних");
            System.out.println("[0] - Вийти");
            try {
                System.out.print("Ваш вибір >>> ");
                choice = IN.nextInt();
                IN.nextLine();
            } catch (Exception e) {
                IN.nextLine();
                System.out.println("Помилка при введенні!");
                choice = -1;
            }
            if (choice == 1 || choice == 2) {
                company = getCurrentCompany();
                System.out.println(choice == 1 ? "\n\t\t***Створення тарифу***" : "\n\t\t***Створення пакету даних***");
                getCurrentCompany().addTariff(choice == 1 ? new Tariff() : new TariffPackage());
                overwriteCompany(company, company.getName());
            }
        } while (choice < 0 || choice > 2);

        setCommands(CompanyMenu.createCommandArray());
    }

    @Override
    public String toString() { return "Створити тариф"; }
}
