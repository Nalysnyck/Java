package com.mobileconnection.command.companymenucommand;

import com.mobileconnection.command.Command;
import com.mobileconnection.menu.CompanyMenu;
import com.mobileconnection.mobilecompany.MobileCompany;
import com.mobileconnection.tariff.Tariff;
import com.mobileconnection.tariff.TariffPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mobileconnection.Main.IN;
import static com.mobileconnection.menu.Menu.setCommands;
import static com.mobileconnection.service.CompanyService.*;

public class AddTariffCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(AddTariffCommand.class);
    @Override
    public void execute() {
        MobileCompany company;
        CompanyMenu companyMenu = new CompanyMenu();
        Tariff newTariff;
        int choice;
        do {
            System.out.println("\n\t\t***Створити тариф***:");
            System.out.println("[1] - Створити тариф");
            System.out.println("[2] - Створити пакет даних");
            System.out.println("[0] - Вийти");
            try {
                System.out.print("Ваш вибір >>> ");
                choice = Integer.parseInt(IN.nextLine());
            } catch (Exception e) {
                System.out.println("Помилка при введенні!");
                choice = -1;
                logger.error("Помилка при вводі!", e);
            }
            if (choice == 1 || choice == 2) {
                company = getCurrentCompany();
                System.out.println(choice == 1 ? "\n\t\t***Створення тарифу***" : "\n\t\t***Створення пакету даних***");
                newTariff = (choice == 1 ? new Tariff() : new TariffPackage());
                company.addTariff(newTariff);
                overwriteCompany(company, company.getName());
                logger.info("Додано " + (choice == 1 ? "тариф" : "пакет даних") + " \"" + newTariff.getName() + "\"" + "у компанію \"" + company.getName() + "\"!");
            }
        } while (choice < 0 || choice > 2);

        setCommands(companyMenu.createCommandArray(getCurrentCompany()));
    }

    @Override
    public String toString() { return "Створити тариф"; }
}
