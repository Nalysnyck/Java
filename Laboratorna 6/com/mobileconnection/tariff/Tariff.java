package mobileconnection.tariff;

import java.io.Serializable;

import static mobileconnection.Main.IN;

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

    public Tariff(){
        while(true) {
            try {
                System.out.print("Назва >>> ");
                setName(IN.nextLine());
                System.out.print("Вартість абонплати(грн) >>> ");
                setCostPerMonth(IN.nextDouble());
                if (getCostPerMonth() < 0) throw new Exception();
                System.out.print("Кількість хвилин(-1 - безліміт) >>> ");
                setCallMinutes(IN.nextInt());
                if (getCallMinutes() < -1) throw new Exception();
                System.out.print("Кількість хвилин на інші мережі(-1 - безліміт) >>> ");
                setCallMinutesOnOtherNumbers(IN.nextInt());
                if (getCallMinutesOnOtherNumbers() < -1) throw new Exception();
                System.out.print("Кількість хвилин в роумінгу(-1 - безліміт) >>> ");
                setCallMinutesInRoaming(IN.nextInt());
                if (getCallMinutesInRoaming() < -1) throw new Exception();
                System.out.print("Мобільний інтернет(МБ)(-1 - безліміт) >>> ");
                setTraffic(IN.nextInt());
                if (getTraffic() < -1) throw new Exception();
                System.out.print("Кількість безкоштовних смс(-1 - безліміт) >>> ");
                setFreeSmsNumber(IN.nextInt());
                if (getFreeSmsNumber() < -1) throw new Exception();
                System.out.print("Знижка(%) >>> ");
                setDiscount(IN.nextInt());
                IN.nextLine();
                if (getDiscount() < 0) throw new Exception();
                System.out.print("Програми без плати за трафік >>> ");
                setAppsWithoutTraffic(IN.nextLine());
                System.out.print("Кількість користувачів >>> ");
                setUsersNumber(IN.nextInt());
                IN.nextLine();
                if (getUsersNumber() < 0) throw new Exception();
                break;
            } catch (Exception e) {
                IN.nextLine();
                System.out.println("Неправильні дані! Спробуйте ще:\n");
            }
        }
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
