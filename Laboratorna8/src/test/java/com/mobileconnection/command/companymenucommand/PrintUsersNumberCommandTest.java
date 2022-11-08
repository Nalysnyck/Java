package com.mobileconnection.command.companymenucommand;

import com.mobileconnection.mobilecompany.MobileCompany;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PrintUsersNumberCommandTest {
    @InjectMocks
    PrintUsersNumberCommand printUsersNumberCommand;
    @Mock
    MobileCompany currentCompany;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() {
        when(currentCompany.getName()).thenReturn("Test");
        when(currentCompany.getUsersNumber()).thenReturn(1);

        printUsersNumberCommand.execute();

        verify(currentCompany, times(1)).getName();
        verify(currentCompany, times(1)).getUsersNumber();
    }

    @Test
    public void testToString() {
        assertEquals("Вивести кількість користувачів компанії", printUsersNumberCommand.toString());
    }

}