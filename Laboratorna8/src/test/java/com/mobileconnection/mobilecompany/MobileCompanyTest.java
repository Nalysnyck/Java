package com.mobileconnection.mobilecompany;

import com.mobileconnection.tariff.Tariff;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class MobileCompanyTest {

    @InjectMocks
    private MobileCompany mobileCompany;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructorWithParameters() {
        mobileCompany = new MobileCompany("Test");
        assertEquals("Test", mobileCompany.getName());
        assertEquals(mobileCompany.getUsersNumber(), 0);
        Assert.assertNull(mobileCompany.getTariffs());
    }

    @Test
    public void testSortTwoTariffs(){
        mobileCompany.setTariffs(new Tariff[]{
                new Tariff("Test1", 120.00, 200, 60, 30, 10000, 20, 0, "Telegram, Instagram", 2673),
                new Tariff("Test2", 100.00, 220, 60, 30, 10000, 20, 0, "Telegram, Instagram", 1263)
        });
        mobileCompany.sortTariffs();
        assertEquals(mobileCompany.getTariffs()[0].getName(), "Test2");
        assertEquals(mobileCompany.getTariffs()[1].getName(), "Test1");
    }

    @Test
    public void testSortThreeTariffs(){
        mobileCompany.setTariffs(new Tariff[]{
                new Tariff("Test1", 120.00, 200, 60, 30, 10000, 20, 0, "Telegram, Instagram", 2673),
                new Tariff("Test2", 90.00, 220, 60, 30, 10000, 20, 0, "Telegram, Instagram", 1263),
                new Tariff("Test3", 100.00, 220, 60, 30, 10000, 20, 0, "Telegram, Instagram", 1263)
        });
        mobileCompany.sortTariffs();
        assertEquals(mobileCompany.getTariffs()[0].getName(), "Test2");
        assertEquals(mobileCompany.getTariffs()[1].getName(), "Test3");
        assertEquals(mobileCompany.getTariffs()[2].getName(), "Test1");
    }

    @Test
    public void testNoTariffs(){
        Exception exception = assertThrows(NullPointerException.class, () -> mobileCompany.sortTariffs());
        assertEquals("Cannot read the array length because \"a\" is null", exception.getMessage());
        Assert.assertNull(mobileCompany.getTariffs());
    }

    @Test
    public void testAddTariffToNullMassive(){
        mobileCompany.addTariff(new Tariff("Test1", 110.00, 200, 60, 30, 10000, 20, 0, "Telegram, Instagram", 2673));
        assertEquals(mobileCompany.getTariffs()[0].getName(), "Test1");
        assertEquals(mobileCompany.getUsersNumber(), 2673);
    }

    @Test
    public void testAddTariffToNotNullMassive(){
        mobileCompany.addTariff(new Tariff("Test1", 120.00, 200, 60, 30, 10000, 20, 0, "Telegram, Instagram", 2673));
        mobileCompany.addTariff(new Tariff("Test2", 100.00, 220, 60, 30, 10000, 20, 0, "Telegram, Instagram", 1263));
        mobileCompany.addTariff(new Tariff("Test3", 110.00, 200, 60, 30, 10000, 20, 0, "Telegram, Instagram", 2673));
        assertEquals(mobileCompany.getTariffs()[0].getName(), "Test1");
        assertEquals(mobileCompany.getTariffs()[1].getName(), "Test2");
        assertEquals(mobileCompany.getTariffs()[2].getName(), "Test3");
        assertEquals(mobileCompany.getUsersNumber(), 6609);
    }

    @Test
    public void testDeleteTariffFromMassive(){
        Tariff tariffToDelete;
        mobileCompany.addTariff(new Tariff("Test1", 120.00, 200, 60, 30, 10000, 20, 0, "Telegram, Instagram", 2673));
        mobileCompany.addTariff(tariffToDelete = new Tariff("Test2", 100.00, 220, 60, 30, 10000, 20, 0, "Telegram, Instagram", 1263));
        mobileCompany.addTariff(new Tariff("Test3", 110.00, 200, 60, 30, 10000, 20, 0, "Telegram, Instagram", 2673));
        mobileCompany.deleteTariff(tariffToDelete);
        assertEquals(mobileCompany.getTariffs()[0].getName(), "Test1");
        assertEquals(mobileCompany.getTariffs()[1].getName(), "Test3");
        assertEquals(mobileCompany.getUsersNumber(), 5346);
    }

    @Test
    public void testDeleteTariffWhenNoElementsInMassive(){
        Tariff tariffToDelete = new Tariff("Test2", 100.00, 220, 60, 30, 10000, 20, 0, "Telegram, Instagram", 1263);
        Exception exception = assertThrows(NullPointerException.class, () -> mobileCompany.deleteTariff(tariffToDelete));
        assertEquals("Cannot read the array length because \"oldTariffs\" is null", exception.getMessage());
        assertEquals(mobileCompany.getUsersNumber(), 0);
    }

    @Test
    public void testSearchTariffByCostPerMonthWhenNoElementsInMassive(){
        Exception exception = assertThrows(NullPointerException.class, () -> mobileCompany.searchTariff(1, 105.0, 135.0));
        assertEquals("Cannot read the array length because \"tariffs\" is null", exception.getMessage());
    }

    @Test
    public void testSearchTariffByCostPerMonth(){
        Tariff[] tariffs = new Tariff[]{
                new Tariff("Test1", 120.00, 200, 60, 30, 10000, 20, 0, "Telegram, Instagram", 2673),
                new Tariff("Test2", 100.00, 220, 60, 30, 10000, 20, 0, "Telegram, Instagram", 1263),
                new Tariff("Test3", 110.00, 220, 60, 30, 10000, 20, 0, "Telegram, Instagram", 1263)
        };

        mobileCompany.setTariffs(tariffs);
        assertEquals(new Tariff[]{tariffs[0], tariffs[2]}, mobileCompany.searchTariff(1, 105.0, 135.0));
    }

    @Test
    public void testSearchTariffByTraffic(){
        Tariff[] tariffs = new Tariff[]{
                new Tariff("Test1", 120.00, 200, 60, 30, 15000, 20, 0, "Telegram, Instagram", 2673),
                new Tariff("Test2", 100.00, 220, 60, 30, 5000, 20, 0, "Telegram, Instagram", 1263),
                new Tariff("Test3", 110.00, 220, 60, 30, 8000, 20, 0, "Telegram, Instagram", 1263)
        };

        mobileCompany.setTariffs(tariffs);
        assertEquals(new Tariff[]{tariffs[0]}, mobileCompany.searchTariff(2, 10000.0, 20000.0));
    }

    @Test
    public void testSearchTariffByCallMinutesOnOtherNumbers(){
        Tariff[] tariffs = new Tariff[]{
                new Tariff("Test1", 120.00, 200, 140, 30, 15000, 20, 0, "Telegram, Instagram", 2673),
                new Tariff("Test2", 100.00, 220, 80, 30, 5000, 20, 0, "Telegram, Instagram", 1263),
                new Tariff("Test3", 110.00, 220, 60, 30, 8000, 20, 0, "Telegram, Instagram", 1263)
        };

        mobileCompany.setTariffs(tariffs);
        assertEquals(new Tariff[]{tariffs[0], tariffs[1]}, mobileCompany.searchTariff(3, 80.0, 200.0));
    }

    @Test
    public void testSearchTariffByTrafficWhenNoElementsInMassive(){
        Exception exception = assertThrows(NullPointerException.class, () -> mobileCompany.searchTariff(2, 10000.0, 20000.0));
        assertEquals("Cannot read the array length because \"tariffs\" is null", exception.getMessage());
    }
}