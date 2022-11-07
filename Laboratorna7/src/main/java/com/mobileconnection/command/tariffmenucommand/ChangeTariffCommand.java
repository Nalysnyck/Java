package com.mobileconnection.command.tariffmenucommand;

import com.mobileconnection.command.Command;
import com.mobileconnection.menu.TariffMenu;
import com.mobileconnection.mobilecompany.MobileCompany;
import com.mobileconnection.tariff.Tariff;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.mobileconnection.Main.IN;
import static com.mobileconnection.menu.Menu.setCommands;
import static com.mobileconnection.service.CompanyService.*;

public class ChangeTariffCommand implements Command {
    @Override
    public void execute() {
        MobileCompany company = getCurrentCompany();
        Tariff tariff = getCurrentTariff();
        int indexOfTariff = Arrays.asList(company.getTariffs()).indexOf(tariff), choice;
        Field[] fields = getFields(tariff);

        for (Field field : fields)
            field.setAccessible(true);

        while(true) {
            System.out.println("\n\t\t***Зміна даних тарифу***:");
            for (int i = 0; i < fields.length; i++)
                try {
                    System.out.println("[" + (i + 1) + "] - " + fields[i].getName() + " = " + fields[i].get(tariff));
                } catch (Exception e) {
                    System.out.println("Помилка доступу!");
                }
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
            if (choice > 0 && choice <= fields.length) {
                setField(choice, fields, tariff);
                company.setTariff(tariff, indexOfTariff);
                setCurrentCompany(company);
                setCurrentTariff(company.getTariffs()[indexOfTariff]);
                overwriteCompany(company, company.getName());
            }
        }
        for (Field field : fields)
            field.setAccessible(false);
        TariffMenu tariffMenu = new TariffMenu();
        setCommands(tariffMenu.createCommandArray());
    }

    private static Field[] getFields(Tariff tariff) {
        Field[] fields1 = tariff.getClass().getSuperclass().getDeclaredFields();
        Field[] fields2 = tariff.getClass().getDeclaredFields();
        Field[] fields = new Field[fields1.length + fields2.length];
        System.arraycopy(fields1, 0, fields, 0, fields1.length);
        System.arraycopy(fields2, 0, fields, fields1.length, fields2.length);
        for (Field field : fields)
            field.setAccessible(true);
        return fields;
    }
    private static void setField(int choice, Field[] fields, Tariff tariff) {
        System.out.print("Введіть нове значення поля \"" + fields[choice - 1].getName() + "\": ");
        try {
            if (fields[choice - 1].getType() == int.class)
                fields[choice - 1].set(tariff, IN.nextInt());
            else if (fields[choice - 1].getType() == double.class)
                fields[choice - 1].set(tariff, IN.nextDouble());

            IN.nextLine();

            if (fields[choice - 1].getType() == String.class)
                fields[choice - 1].set(tariff, IN.nextLine());
        } catch (Exception e) {
            IN.nextLine();
            System.out.println("Помилка введення даних!");
        }
    }

    public String toString() {
        return "Змінити параметри тарифу";
    }
}
