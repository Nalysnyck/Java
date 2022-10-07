package mobileconnection.mobilecompany;

import mobileconnection.tariff.Tariff;

import java.util.Arrays;
import java.util.Comparator;

public class MobileCompany {
    private String name;
    private int usersNumber;
    private Tariff[] tariffs;

    public MobileCompany() {}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Tariff[] getTariffs() {
        return tariffs;
    }

    public int getUsersNumber() {
        for (Tariff tariff : tariffs) {
            usersNumber += tariff.getUsersNumber();
        }
        return usersNumber;
    }

    public void sortByCost(){
        Comparator<Tariff> byCostPerMonth = Comparator.comparing(Tariff::getCostPerMonth);
        Comparator<Tariff> byName = Comparator.comparing(Tariff::getName);

        Arrays.sort(tariffs, byCostPerMonth.thenComparing(byName));
    }

    public void addTariff(Tariff tariff){
        Tariff[] newTariffs = new Tariff[tariffs.length + 1];
        System.arraycopy(tariffs, 0, newTariffs, 0, tariffs.length);
        newTariffs[newTariffs.length - 1] = tariff;
        tariffs = newTariffs;
    }

    public void deleteTariff(Tariff tariff){
        Tariff[] newTariffs = new Tariff[tariffs.length - 1];
        int index = 0;
        for (Tariff t : tariffs)
            if (!t.equals(tariff))
                newTariffs[index++] = t;
        tariffs = newTariffs;
    }

    public void changeTariff(Tariff tariff, Tariff newTariff){

    }

    public void searchTariffByCost(int cost){

    }

    public void searchTariffByTraffic(int traffic){

    }

    public void searchTariffByMinutesOnOtherNumbers(String name){

    }
}