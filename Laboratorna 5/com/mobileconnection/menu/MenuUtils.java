package mobileconnection.menu;

import mobileconnection.command.Command;

import java.util.Scanner;

public class MenuUtils {
    public static final Scanner IN = new Scanner(System.in);

    public static void menuLoop(Command[] commandArray, String menuName, String emptyMenuMessage, int firstCommandIndex){
        int choice;

        while (true) {
            printMenu(commandArray, menuName, emptyMenuMessage, firstCommandIndex);

            try {
                System.out.print("Ваш вибір >>> ");
                choice = IN.nextInt();
            } catch (Exception e) {
                IN.nextLine();
                choice = -2;
            }

            if (choice == -1)
                break;
            if (choice > -1 && choice < commandArray.length)
                commandArray[choice].execute();
        }
    }

    public static void printMenu(Command[] commandArray, String message1, String message2, int firstCommandIndex){
        System.out.println(message1);
        if(commandArray.length == firstCommandIndex)
            System.out.println(message2);
        for (int i = 0; i < commandArray.length; i++)
            System.out.println("[" + i + "] - " + commandArray[i]);
        System.out.println("[-1] - Вийти");
    }
}
