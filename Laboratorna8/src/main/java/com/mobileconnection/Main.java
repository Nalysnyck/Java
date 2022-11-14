package com.mobileconnection;

import com.mobileconnection.menu.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Main {
    public static final Scanner IN = new Scanner(System.in);
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Початок роботи програми");
        MainMenu mainMenu = new MainMenu();
        mainMenu.execute();
    }
}