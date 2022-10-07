package mobileconnection.tariff;

public class TariffPackage extends Tariff {
    private int daysOfUsing;

    public TariffPackage() {}

    public int getDaysOfUsing() {return daysOfUsing;}
    public void setDaysOfUsing(int daysOfUsing) {this.daysOfUsing = daysOfUsing;}

    @Override
    public String toString() { return ""; }
}