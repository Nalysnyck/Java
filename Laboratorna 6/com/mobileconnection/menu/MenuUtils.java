package mobileconnection.menu;

import mobileconnection.command.Command;

import java.util.Scanner;

public class MenuUtils {
    public static final Scanner IN = new Scanner(System.in);
    private static Command[] commands;

    public static void menuLoop(Command[] commandArray, String message1, String message2, int firstCommandIndex){
        int choice;
        Command selectedCommand;
        setCommands(commandArray);

        while (true) {
            printMenu(commands, message1, message2, firstCommandIndex);

            try {
                System.out.print("Ваш вибір >>> ");
                choice = IN.nextInt();
                IN.nextLine();
            } catch (Exception e) {
                IN.nextLine();
                choice = -1;
            }

            if (choice == 0)
                break;
            if (choice > 0 && choice <= commands.length) {
                selectedCommand = commands[choice - 1];
                selectedCommand.execute();
                if (selectedCommand.getClass().getSimpleName().startsWith("Delete"))
                    return;
            }
        }
        setCommands(null);
    }

    public static void printMenu(Command[] commandArray, String message1, String message2, int firstCommandIndex){
        System.out.println(message1);
        if(commandArray.length == firstCommandIndex)
            System.out.println(message2);
        for (int i = 0; i < commandArray.length; i++)
            System.out.println("[" + (i + 1) + "] - " + commandArray[i]);
        System.out.println("[0] - Вийти");
    }

    public static Command[] getCommands() { return commands; }
    public static void setCommands(Command[] commands) { MenuUtils.commands = commands; }
}
