package mobileconnection.command.companymenucommand;

import mobileconnection.command.Command;
import mobileconnection.tariff.Tariff;

import static mobileconnection.menu.MenuUtils.IN;
import static mobileconnection.service.CompanyService.getCurrentCompany;

public class SearchTariffCommand implements Command {
    public void execute(){
        Tariff[] foundTariffs;
        int choice;
        while(true) {
            System.out.print("\n\tОберіть тип пошуку:"
                    + "\n1. За вартістю"
                    + "\n2. За трафіком"
                    + "\n3. За кількістю хвилин на інші мережі"
                    + "\nВаш вибір >>> ");

            try {
                choice = IN.nextInt();
            } catch (Exception e) {
                IN.nextLine();
                choice = 0;
            }

            if (choice == 0)
                break;
            if (choice > 0 && choice < 4) {
                foundTariffs = getCurrentCompany().searchTariff(choice);
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
