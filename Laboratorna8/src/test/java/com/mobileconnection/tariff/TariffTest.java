package com.mobileconnection.tariff;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TariffTest {
    @Mock
    private Tariff tariff;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructorWithoutParametersForFailure() {
        System.setIn(new ByteArrayInputStream("Test\n100\n100\n100.00\n100\n100\n100\n100\n\n1234\n".getBytes()));
        assertThrows(IllegalArgumentException.class, () -> tariff = new Tariff());
    }

    @Test
    public void testConstructorWithParameters() {
        tariff = new Tariff("Test", 100, 100, 100, 100, 100, 100, 100, "Telegram, Instagram", 1234);
        assertEquals("Test", tariff.getName());
        assertEquals(100, tariff.getCallMinutes());
        assertEquals(100, tariff.getCallMinutesOnOtherNumbers());
        assertEquals(100, tariff.getCallMinutesInRoaming());
        assertEquals(100, tariff.getTraffic());
        assertEquals(100, tariff.getFreeSmsNumber());
        assertEquals(100, tariff.getDiscount());
        assertEquals("Telegram, Instagram", tariff.getAppsWithoutTraffic());
        assertEquals(1234, tariff.getUsersNumber());
    }

    @Test
    public void testToString() {
        tariff = new Tariff("Test", 100, 100, 100, 100, 100, 100, 10, "Telegram, Instagram", 1234);
        assertEquals("""
                             Тариф "Test"
                Місячна абонплата......................100,00 грн (знижка 10%)
                Дзвінки................................100 хв
                Дзвінки на інші мережі.................100 хв
                Дзвінки у роумінгу.....................100 хв
                Мобільний інтернет.....................100 Мб
                Кількість безкоштовних СМС.............100 шт
                Додатки без плати за трафік: Telegram, Instagram
                               
                Кількість користувачів тарифу..........1234
                               
                """, tariff.toString());
    }

}