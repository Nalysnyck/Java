package com.mobileconnection.menu;

import com.mobileconnection.command.Command;
import com.mobileconnection.tariff.Tariff;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.mobileconnection.service.CompanyService.setCurrentCompany;
import static com.mobileconnection.service.CompanyService.setCurrentTariff;
import static org.junit.Assert.*;

public class TariffMenuTest {
    @InjectMocks
    TariffMenu tariffMenu;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCommandArray() {
        // given
        String expected1 = "ChangeTariffCommand";
        String expected2 = "DeleteTariffCommand";

        // then
        Command[] result = tariffMenu.createCommandArray();
        assertEquals(2, result.length);
        assertEquals(expected1, result[0].getClass().getSimpleName());
        assertEquals(expected2, result[1].getClass().getSimpleName());
    }

    @Test
    public void testGetMessage1() {
        // given
        String expected = """
                             Тариф "Test"
                Місячна абонплата......................100,00 грн (знижка 10%)
                Дзвінки................................100 хв
                Дзвінки на інші мережі.................100 хв
                Дзвінки у роумінгу.....................100 хв
                Мобільний інтернет.....................100 Мб
                Кількість безкоштовних СМС.............100 шт
                Додатки без плати за трафік: Telegram, Instagram
                               
                Кількість користувачів тарифу..........1234
                               
                """;
        setCurrentTariff(new Tariff("Test", 100, 100, 100, 100, 100, 100, 10, "Telegram, Instagram", 1234));

        // then
        String result = tariffMenu.getMessage1();
        assertEquals(expected, result);
        setCurrentTariff(null);
    }

    @Test
    public void testGetMessage2() {
        // given
        String expected = "";

        // then
        String result = tariffMenu.getMessage2();
        assertEquals(expected, result);
    }
}