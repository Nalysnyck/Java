package com.mobileconnection.menu;

import com.mobileconnection.mobilecompany.MobileCompany;
import com.mobileconnection.service.CompanyService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class MainMenuTest {
    @InjectMocks
    MainMenu mainMenu;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCommandArrayWhenNoCompanies() {
        // given
        String expected = "AddCompanyCommand";

        // then
        assertEquals(1, mainMenu.createCommandArray(null).length);
        assertEquals(expected, mainMenu.createCommandArray(null)[0].getClass().getSimpleName());
    }

    @Test
    public void testCreateCommandArrayWhenCompaniesExist() {
        // given
        String expected1 = "ChooseCompanyCommand";
        String expected2 = "AddCompanyCommand";
        MobileCompany[] companies = new MobileCompany[]{new MobileCompany("Test")};

        // then
        assertEquals(2, mainMenu.createCommandArray(companies).length);
        assertEquals(expected1, mainMenu.createCommandArray(companies)[0].getClass().getSimpleName());
        assertEquals(expected2, mainMenu.createCommandArray(companies)[1].getClass().getSimpleName());
    }

    @Test
    public void testGetMessage1() {
        assertEquals("\n\t\t***Головне меню***", mainMenu.getMessage1());
    }

    @Test
    public void testGetMessage2() {
        assertEquals("Ще немає компаній...", mainMenu.getMessage2());
    }
}