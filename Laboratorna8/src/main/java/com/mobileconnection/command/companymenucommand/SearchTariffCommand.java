package com.mobileconnection.command.companymenucommand;

import com.mobileconnection.MyLogger;
import com.mobileconnection.command.Command;
import com.mobileconnection.tariff.Tariff;

import static com.mobileconnection.Main.IN;
import static com.mobileconnection.service.CompanyService.getCurrentCompany;

public class SearchTariffCommand implements Command {
    public void execute(){
        Tariff[] foundTariffs;
        int choice;
        double lowerBound = 0, upperBound = 0;

        while(true) {
            System.out.print("\n\tОберіть тип пошуку:"
                    + "\n1. За вартістю"
                    + "\n2. За трафіком"
                    + "\n3. За кількістю хвилин на інші мережі"
                    + "\nВаш вибір >>> ");

            try {
                choice = Integer.parseInt(IN.nextLine());
            } catch (Exception e) {
                choice = -1;
                MyLogger.logger.severe("Некоректний ввід");
            }

            if (choice == 0)
                break;
            if (choice > 0 && choice < 4) {
                try {
                    System.out.println("Введіть нижню межу пошуку: ");
                    lowerBound = Double.parseDouble(IN.nextLine());
                    System.out.println("Введіть верхню межу пошуку: ");
                    upperBound = Double.parseDouble(IN.nextLine());
                    if (lowerBound > upperBound) {
                        double tmp1 = lowerBound;
                        lowerBound = upperBound;
                        upperBound = tmp1;
                    }
                } catch (Exception e) {
                    System.out.println("Невірно введені дані!");
                    MyLogger.logger.severe("Введення неправильного типу даних!");
                    continue;
                }
                foundTariffs = getCurrentCompany().searchTariff(choice, lowerBound, upperBound);
                MyLogger.logger.info("Здійснено пошук тарифів у компанії \"" + getCurrentCompany().getName() + "\"!");
                if (foundTariffs != null) {
                    if (foundTariffs.length == 0)
                        System.out.println("Тарифів не знайдено");
                    else {
                        System.out.println("\tЗнайдені тарифи:");
                        new ChooseTariffCommand(foundTariffs).execute();
                    }
                }
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Пошук тарифу";
    }
}
