package mobileconnection.tariff;

import java.io.Serializable;

import static mobileconnection.Main.IN;

public class TariffPackage extends Tariff implements Serializable {
    private String daysOfUsing;

    public TariffPackage() {
        super();
        System.out.print("Час використання пакету даних(дні/місяці/роки) >>> ");
        setDaysOfUsing(IN.nextLine());
    }

    public String getDaysOfUsing() {return daysOfUsing;}
    public void setDaysOfUsing(String daysOfUsing) {this.daysOfUsing = daysOfUsing;}

    @Override
    public String toString() { return String.format("""
                     Пакет даних "%s"
            Ціна...................................%.2f грн %s
            Час використання.......................%s
            Дзвінки................................%s
            Дзвінки на інші мережі.................%s
            Дзвінки у роумінгу.....................%s
            Мобільний інтернет.....................%s
            Кількість безкоштовних СМС.............%s
            Додатки без плати за трафік: %s
            
            Кількість користувачів пакету..........%d
            
            """, getName(), getCostPerMonth(),
            getDiscount() == 0 ? "" : "(знижка " + getDiscount() + "%)", getDaysOfUsing(),
            getCallMinutes() == -1 ? "Безліміт" : getCallMinutes() + " хв",
            getCallMinutesOnOtherNumbers() == -1 ? "Безліміт" : getCallMinutesOnOtherNumbers() + " хв",
            getCallMinutesInRoaming() == -1 ? "Безліміт" : getCallMinutesInRoaming() + " хв",
            getTraffic() == -1 ? "Безліміт" : getTraffic() + " Мб",
            getFreeSmsNumber() == -1 ? "Безліміт" : getFreeSmsNumber() + " шт",
            getAppsWithoutTraffic() == null ? "Немає" : getAppsWithoutTraffic(), getUsersNumber());
    }
}