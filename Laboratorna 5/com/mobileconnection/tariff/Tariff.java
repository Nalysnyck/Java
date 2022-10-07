package mobileconnection.tariff;

public class Tariff {
    private String name;
    private double costPerMonth;
    private int callMinutes;
    private int callMinutesOnOtherNumbers;
    private int callMinutesInRoaming;
    private int megabytesOfInternet;
    private int freeSmsNumber;
    private int discount;
    private String[] appsWithoutTraffic;
    private int usersNumber;

    public Tariff(){}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public double getCostPerMonth() {return costPerMonth;}
    public void setCostPerMonth(double costPerMonth) {this.costPerMonth = costPerMonth;}

    public int getCallMinutes() {return callMinutes;}
    public void setCallMinutes(int callMinutes) {this.callMinutes = callMinutes;}

    public int getCallMinutesOnOtherNumbers() {return callMinutesOnOtherNumbers;}
    public void setCallMinutesOnOtherNumbers(int callMinutesOnOtherNumbers) {this.callMinutesOnOtherNumbers = callMinutesOnOtherNumbers;}

    public int getCallMinutesInRoaming() {return callMinutesInRoaming;}
    public void setCallMinutesInRoaming(int callMinutesInRoaming) {this.callMinutesInRoaming = callMinutesInRoaming;}

    public int getMegabytesOfInternet() {return megabytesOfInternet;}
    public void setMegabytesOfInternet(int megabytesOfInternet) {this.megabytesOfInternet = megabytesOfInternet;}

    public int getFreeSmsNumber() {return freeSmsNumber;}
    public void setFreeSmsNumber(int freeSmsNumber) {this.freeSmsNumber = freeSmsNumber;}

    public int getDiscount() {return discount;}
    public void setDiscount(int discount) {this.discount = discount;}

    public String[] getAppsWithoutTraffic() {return appsWithoutTraffic;}
    public void setAppsWithoutTraffic(String[] appsWithoutTraffic) {this.appsWithoutTraffic = appsWithoutTraffic;}

    public int getUsersNumber() {return usersNumber;}
    public void setUsersNumber(int usersNumber) {this.usersNumber = usersNumber;}

    @Override
    public String toString() { return ""; }
}
