package com.mobileconnection.menu;

import com.mobileconnection.command.Command;
import com.mobileconnection.mobilecompany.MobileCompany;
import com.mobileconnection.tariff.Tariff;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.mobileconnection.service.CompanyService.setCurrentCompany;
import static org.junit.Assert.*;

public class CompanyMenuTest {
    @InjectMocks
    CompanyMenu companyMenu;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCommandArrayWhenNoTariffs() {
        // given
        String expected1 = "AddTariffCommand";
        String expected2 = "PrintUsersNumberCommand";
        String expected3 = "ChangeCompanyCommand";
        String expected4 = "DeleteCompanyCommand";

        // then
        Command[] result = companyMenu.createCommandArray(new MobileCompany("TestCompany"));
        assertEquals(4, result.length);
        assertEquals(expected1, result[0].getClass().getSimpleName());
        assertEquals(expected2, result[1].getClass().getSimpleName());
        assertEquals(expected3, result[2].getClass().getSimpleName());
        assertEquals(expected4, result[3].getClass().getSimpleName());
    }

    @Test
    public void testCreateCommandArrayWhenTariffsExist() {
        // given
        String expected1 = "ChooseTariffCommand";
        String expected2 = "AddTariffCommand";
        String expected3 = "SortTariffCommand";
        String expected4 = "SearchTariffCommand";
        String expected5 = "PrintUsersNumberCommand";
        String expected6 = "ChangeCompanyCommand";
        String expected7 = "DeleteCompanyCommand";
        MobileCompany mobileCompany = new MobileCompany("TestCompany");
        mobileCompany.setTariffs(new Tariff[]{new Tariff("Test1", 120.00, 200, 60, 30, 15000, 20, 0, "Telegram, Instagram", 2673)});

        // then
        Command[] result = companyMenu.createCommandArray(mobileCompany);
        assertEquals(7, result.length);
        assertEquals(expected1, result[0].getClass().getSimpleName());
        assertEquals(expected2, result[1].getClass().getSimpleName());
        assertEquals(expected3, result[2].getClass().getSimpleName());
        assertEquals(expected4, result[3].getClass().getSimpleName());
        assertEquals(expected5, result[4].getClass().getSimpleName());
        assertEquals(expected6, result[5].getClass().getSimpleName());
        assertEquals(expected7, result[6].getClass().getSimpleName());
    }

    @Test
    public void testGetMessage1() {
        // given
        String expected = "\n\t\t***Меню компанії \"TestCompany\"***";
        setCurrentCompany(new MobileCompany("TestCompany"));

        // then
        assertEquals("\n\t\t***Меню компанії \"TestCompany\"***", companyMenu.getMessage1());
        setCurrentCompany(null);
    }

    @Test
    public void testGetMessage2() {
        assertEquals("Ще немає компаній...", companyMenu.getMessage2());
    }
}