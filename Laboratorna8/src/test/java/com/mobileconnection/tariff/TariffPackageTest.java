package com.mobileconnection.tariff;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class TariffPackageTest {
    @Mock
    TariffPackage tariffPackage;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructorWithoutParameters() {
        System.setIn(new ByteArrayInputStream("Test\n100\n100\n100\n100\n100\n100\n100\nTelegram, Instagram\n1234\n30 днів".getBytes()));
        tariffPackage = new TariffPackage();
        assertEquals("Test", tariffPackage.getName());
        assertEquals(100, tariffPackage.getCallMinutes());
        assertEquals(100, tariffPackage.getCallMinutesOnOtherNumbers());
        assertEquals(100, tariffPackage.getCallMinutesInRoaming());
        assertEquals(100, tariffPackage.getTraffic());
        assertEquals(100, tariffPackage.getFreeSmsNumber());
        assertEquals(100, tariffPackage.getDiscount());
        assertEquals("Telegram, Instagram", tariffPackage.getAppsWithoutTraffic());
        assertEquals(1234, tariffPackage.getUsersNumber());
        assertEquals("30 днів", tariffPackage.getDaysOfUsing());
    }

    @Test
    public void testConstructorWithParameters() {
        tariffPackage = new TariffPackage("Test", 100, 100, 100, 100, 100, 100, 100, "Telegram, Instagram", 1234, "30 днів");
        assertEquals("Test", tariffPackage.getName());
        assertEquals(100, tariffPackage.getCallMinutes());
        assertEquals(100, tariffPackage.getCallMinutesOnOtherNumbers());
        assertEquals(100, tariffPackage.getCallMinutesInRoaming());
        assertEquals(100, tariffPackage.getTraffic());
        assertEquals(100, tariffPackage.getFreeSmsNumber());
        assertEquals(100, tariffPackage.getDiscount());
        assertEquals("Telegram, Instagram", tariffPackage.getAppsWithoutTraffic());
        assertEquals(1234, tariffPackage.getUsersNumber());
        assertEquals("30 днів", tariffPackage.getDaysOfUsing());
    }

    @Test
    public void testToString() {
        tariffPackage = new TariffPackage("Test", 100, 100, 100, 100, 100, 100, 10, "Telegram, Instagram", 1234, "30 днів");
        assertEquals("""
                         Пакет даних "Test"
                Ціна...................................100,00 грн (знижка 10%)
                Час використання.......................30 днів
                Дзвінки................................100 хв
                Дзвінки на інші мережі.................100 хв
                Дзвінки у роумінгу.....................100 хв
                Мобільний інтернет.....................100 Мб
                Кількість безкоштовних СМС.............100 шт
                Додатки без плати за трафік: Telegram, Instagram
                           
                Кількість користувачів пакету..........1234
                           
                """, tariffPackage.toString());
    }

}