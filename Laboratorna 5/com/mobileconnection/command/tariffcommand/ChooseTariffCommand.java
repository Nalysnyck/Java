package mobileconnection.command.tariffcommand;

import mobileconnection.command.Command;
import mobileconnection.tariff.Tariff;

import static mobileconnection.menu.MenuUtils.IN;

public class ChooseTariffCommand implements Command {
    private final Tariff[] tariffs;

    @Override
    public void execute() {
        int choice;

        while (true) {
            System.out.println("\t\t***Список тарифів***:");
            for (int i = 0; i < tariffs.length; i++)
                System.out.println("[" + i + "] - " + tariffs[i]);
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
            if (choice > -1 && choice < tariffs.length)
                ;
        }
    }

    public ChooseTariffCommand(Tariff[] tariffs) {
        this.tariffs = tariffs;
    }
}
