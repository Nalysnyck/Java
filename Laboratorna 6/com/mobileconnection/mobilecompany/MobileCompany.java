package mobileconnection.mobilecompany;

import mobileconnection.tariff.Tariff;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

import static mobileconnection.Main.IN;

public class MobileCompany implements Serializable {
    private String name;
    private int usersNumber;
    private Tariff[] tariffs;

    public MobileCompany() {
        System.out.println("\n\t\t***Створення компанії***");
        System.out.print("Назва компанії >>> ");
        setName(IN.nextLine());
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Tariff[] getTariffs() {
        return tariffs;
    }
    public void setTariff(Tariff tariff, int index) { this.tariffs[index] = tariff; }

    public int getUsersNumber() { return usersNumber; }

    public void sortTariffs(){
        Comparator<Tariff> byCostPerMonth = Comparator.comparing(Tariff::getCostPerMonth);
        Comparator<Tariff> byName = Comparator.comparing(Tariff::getName);

        Arrays.sort(tariffs, byCostPerMonth.thenComparing(byName));
    }

    public void addTariff(Tariff tariff){
        if (tariffs == null) {
            tariffs = new Tariff[1];
            tariffs[0] = tariff;
        }
        else {
            Tariff[] newTariffs = new Tariff[tariffs.length + 1];
            System.arraycopy(tariffs, 0, newTariffs, 0, tariffs.length);
            newTariffs[newTariffs.length - 1] = tariff;
            tariffs = newTariffs;
        }
        usersNumber += tariff.getUsersNumber();
    }

    public void deleteTariff(Tariff tariff){
        Tariff[] newTariffs = new Tariff[tariffs.length - 1];
        int index = 0;
        for (Tariff t : tariffs)
            if (!t.equals(tariff))
                newTariffs[index++] = t;
        tariffs = newTariffs;
        usersNumber -= tariff.getUsersNumber();
    }

    public Tariff[] searchTariff(int typeOfSearch){
        Tariff[] newTariffs = new Tariff[tariffs.length];
        double lowerBound, upperBound;

        try {
            System.out.println("Введіть нижню межу пошуку: ");
            lowerBound = IN.nextDouble();
            System.out.println("Введіть верхню межу пошуку: ");
            upperBound = IN.nextDouble();
        } catch (Exception e) {
            IN.nextLine();
            System.out.println("Невірно введені дані!");
            return null;
        }

        int i = 0;
        for (Tariff tariff : tariffs) {
            switch (typeOfSearch) {
                case 1:
                    if (tariff.getCostPerMonth() >= lowerBound && tariff.getCostPerMonth() <= upperBound)
                        newTariffs[i++] = tariff;
                    break;
                case 2:
                    if (tariff.getTraffic() >= lowerBound && tariff.getTraffic() <= upperBound)
                        newTariffs[i++] = tariff;
                    break;
                case 3:
                    if (tariff.getCallMinutesOnOtherNumbers() >= lowerBound && tariff.getCallMinutesOnOtherNumbers() <= upperBound)
                        newTariffs[i++] = tariff;
                    break;
            }
        }
        Tariff[] result = new Tariff[i];
        System.arraycopy(newTariffs, 0, result, 0, i);
        return result;
    }
}