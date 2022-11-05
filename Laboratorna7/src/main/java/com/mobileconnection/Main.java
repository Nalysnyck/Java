package com.mobileconnection;

import com.mobileconnection.menu.MainMenu;

import java.util.Scanner;


public class Main {
    public static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.execute();
    }
}