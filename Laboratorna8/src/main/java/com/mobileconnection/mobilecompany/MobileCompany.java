package com.mobileconnection.mobilecompany;

import com.mobileconnection.tariff.Tariff;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

import static com.mobileconnection.Main.IN;

public class MobileCompany implements Serializable {
    private String name;
    private int usersNumber;
    private Tariff[] tariffs;

    public MobileCompany() {
        System.out.println("\n\t\t***Створення компанії***");
        System.out.print("Назва компанії >>> ");
        setName(IN.nextLine());
    }
    public MobileCompany(String name) {
        setName(name);
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Tariff[] getTariffs() {
        return tariffs;
    }
    public void setTariffs(Tariff[] tariffs) {this.tariffs = tariffs;}
    public void setTariff(Tariff tariff, int index) { this.tariffs[index] = tariff; }

    public int getUsersNumber() { return usersNumber; }
    public void setUsersNumber(int usersNumber) { this.usersNumber = usersNumber; }

    public void sortTariffs(){
        Comparator<Tariff> byCostPerMonth = Comparator.comparing(Tariff::getCostPerMonth);
        Comparator<Tariff> byName = Comparator.comparing(Tariff::getName);

        Arrays.sort(getTariffs(), byCostPerMonth.thenComparing(byName));
    }

    public void addTariff(Tariff tariff){
        Tariff[] tariffs = getTariffs();
        if (tariffs == null)
            setTariffs(new Tariff[]{tariff});
        else {
            Tariff[] newTariffs = new Tariff[tariffs.length + 1];
            System.arraycopy(tariffs, 0, newTariffs, 0, tariffs.length);
            newTariffs[newTariffs.length - 1] = tariff;
            setTariffs(newTariffs);
        }
        setUsersNumber(getUsersNumber() + tariff.getUsersNumber());
    }

    public void deleteTariff(Tariff tariff){
        Tariff[] oldTariffs = getTariffs();
        Tariff[] newTariffs = new Tariff[oldTariffs.length - 1];
        int index = 0;
        for (Tariff tar : oldTariffs)
            if (!tar.equals(tariff))
                newTariffs[index++] = tar;
        setTariffs(newTariffs);
        setUsersNumber(getUsersNumber() - tariff.getUsersNumber());
    }

    public Tariff[] searchTariff(int typeOfSearch, double lowerBound, double upperBound){
        Tariff[] tariffs = getTariffs();
        Tariff[] foundTariffs = new Tariff[tariffs.length];

        int i = 0;
        for (Tariff tariff : tariffs) {
            switch (typeOfSearch) {
                case 1:
                    if (tariff.getCostPerMonth() >= lowerBound && tariff.getCostPerMonth() <= upperBound)
                        foundTariffs[i++] = tariff;
                    break;
                case 2:
                    if (tariff.getTraffic() >= lowerBound && tariff.getTraffic() <= upperBound)
                        foundTariffs[i++] = tariff;
                    break;
                case 3:
                    if (tariff.getCallMinutesOnOtherNumbers() >= lowerBound && tariff.getCallMinutesOnOtherNumbers() <= upperBound)
                        foundTariffs[i++] = tariff;
                    break;
            }
        }
        Tariff[] result = new Tariff[i];
        System.arraycopy(foundTariffs, 0, result, 0, i);
        return result;
    }
}