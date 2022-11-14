package com.mobileconnection.menu;

import com.mobileconnection.Main;
import com.mobileconnection.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Menu {
    private static final Logger logger = LoggerFactory.getLogger(Menu.class);
    protected static Command[] commands;

    protected void menuLoop(Command[] commandArray, int firstCommandIndex){
        int choice;
        Command selectedCommand;
        setCommands(commandArray);

        while (true) {
            printMenu(firstCommandIndex);

            try {
                System.out.print("Ваш вибір >>> ");
                choice = Integer.parseInt(Main.IN.nextLine());
            } catch (Exception e) {
                logger.error("Неправильний ввід", e);
                choice = -1;
            }

            if (choice == 0)
                break;
            if (choice > 0 && choice <= getCommands().length) {
                selectedCommand = getCommands()[choice - 1];
                logger.info("Обрано команду: " + selectedCommand);
                selectedCommand.execute();
                if (selectedCommand.getClass().getSimpleName().startsWith("Delete"))
                    return;
            }
        }
    }

    protected void printMenu(int firstCommandIndex){
        System.out.println(this.getMessage1());
        if(getCommands().length == firstCommandIndex)
            System.out.println(this.getMessage2());
        for (int i = 0; i < getCommands().length; i++)
            System.out.println("[" + (i + 1) + "] - " + getCommands()[i]);
        System.out.println("[0] - Вийти");
    }

    protected String getMessage1(){return "";}
    protected String getMessage2(){return "";}

    public Command[] getCommands() { return commands; }
    public static void setCommands(Command[] commands) { Menu.commands = commands; }
}
