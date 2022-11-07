package com.mobileconnection.tariff;

import java.io.Serializable;

import static com.mobileconnection.Main.IN;

public class Tariff  implements Serializable {
    protected String name;
    protected double costPerMonth;
    protected int callMinutes;
    protected int callMinutesOnOtherNumbers;
    protected int callMinutesInRoaming;
    protected int traffic;
    protected int freeSmsNumber;
    protected int discount;
    protected String appsWithoutTraffic;
    protected int usersNumber;

    public Tariff() {
        try {
            System.out.print("Назва >>> ");
            setName(IN.nextLine());
            System.out.print("Вартість абонплати(грн) >>> ");
            setCostPerMonth(Double.parseDouble(IN.nextLine()));
            if (getCostPerMonth() < 0) throw new Exception();
            System.out.print("Кількість хвилин(-1 - безліміт) >>> ");
            setCallMinutes(Integer.parseInt(IN.nextLine()));
            if (getCallMinutes() < -1) throw new Exception();
            System.out.print("Кількість хвилин на інші мережі(-1 - безліміт) >>> ");
            setCallMinutesOnOtherNumbers(Integer.parseInt(IN.nextLine()));
            if (getCallMinutesOnOtherNumbers() < -1) throw new Exception();
            System.out.print("Кількість хвилин в роумінгу(-1 - безліміт) >>> ");
            setCallMinutesInRoaming(Integer.parseInt(IN.nextLine()));
            if (getCallMinutesInRoaming() < -1) throw new Exception();
            System.out.print("Мобільний інтернет(МБ)(-1 - безліміт) >>> ");
            setTraffic(Integer.parseInt(IN.nextLine()));
            if (getTraffic() < -1) throw new Exception();
            System.out.print("Кількість безкоштовних смс(-1 - безліміт) >>> ");
            setFreeSmsNumber(Integer.parseInt(IN.nextLine()));
            if (getFreeSmsNumber() < -1) throw new Exception();
            System.out.print("Знижка(%) >>> ");
            setDiscount(Integer.parseInt(IN.nextLine()));
            if (getDiscount() < 0) throw new Exception();
            System.out.print("Програми без плати за трафік >>> ");
            setAppsWithoutTraffic(IN.nextLine());
            System.out.print("Кількість користувачів >>> ");
            setUsersNumber(Integer.parseInt(IN.nextLine()));
            if (getUsersNumber() < 0) throw new Exception();
        } catch (Exception e) {
            System.out.println("Неправильні дані!\n");
            throw new IllegalArgumentException();
        }
    }
    public Tariff(String name, double costPerMonth, int callMinutes, int callMinutesOnOtherNumbers, int callMinutesInRoaming, int traffic, int freeSmsNumber, int discount, String appsWithoutTraffic, int usersNumber) {
        setName(name);
        setCostPerMonth(costPerMonth);
        setCallMinutes(callMinutes);
        setCallMinutesOnOtherNumbers(callMinutesOnOtherNumbers);
        setCallMinutesInRoaming(callMinutesInRoaming);
        setTraffic(traffic);
        setFreeSmsNumber(freeSmsNumber);
        setDiscount(discount);
        setAppsWithoutTraffic(appsWithoutTraffic);
        setUsersNumber(usersNumber);
    }

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

    public int getTraffic() {return traffic;}
    public void setTraffic(int traffic) {this.traffic = traffic;}

    public int getFreeSmsNumber() {return freeSmsNumber;}
    public void setFreeSmsNumber(int freeSmsNumber) {this.freeSmsNumber = freeSmsNumber;}

    public int getDiscount() {return discount;}
    public void setDiscount(int discount) {this.discount = discount;}

    public String getAppsWithoutTraffic() {return appsWithoutTraffic;}
    public void setAppsWithoutTraffic(String appsWithoutTraffic) {this.appsWithoutTraffic = appsWithoutTraffic;}

    public int getUsersNumber() {return usersNumber;}
    public void setUsersNumber(int usersNumber) {this.usersNumber = usersNumber;}

    @Override
    public String toString() { return String.format("""
                         Тариф "%s"
            Місячна абонплата......................%.2f грн %s
            Дзвінки................................%s
            Дзвінки на інші мережі.................%s
            Дзвінки у роумінгу.....................%s
            Мобільний інтернет.....................%s
            Кількість безкоштовних СМС.............%s
            Додатки без плати за трафік: %s
            
            Кількість користувачів тарифу..........%d
            
            """, getName(), getCostPerMonth(),
            getDiscount() == 0 ? "" : "(знижка " + getDiscount() + "%)",
            getCallMinutes() == -1 ? "Безліміт" : getCallMinutes() + " хв",
            getCallMinutesOnOtherNumbers() == -1 ? "Безліміт" : getCallMinutesOnOtherNumbers() + " хв",
            getCallMinutesInRoaming() == -1 ? "Безліміт" : getCallMinutesInRoaming() + " хв",
            getTraffic() == -1 ? "Безліміт" : getTraffic() + " Мб",
            getFreeSmsNumber() == -1 ? "Безліміт" : getFreeSmsNumber() + " шт",
            getAppsWithoutTraffic() == null ? "Немає" : getAppsWithoutTraffic(), getUsersNumber());
    }
}
