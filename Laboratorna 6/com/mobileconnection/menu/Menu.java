package mobileconnection.menu;

import mobileconnection.Main;
import mobileconnection.command.Command;

public abstract class Menu {
    protected static Command[] commands;

    protected void menuLoop(Command[] commandArray, int firstCommandIndex){
        int choice;
        Command selectedCommand;
        setCommands(commandArray);

        while (true) {
            printMenu(getCommands(), firstCommandIndex);

            try {
                System.out.print("Ваш вибір >>> ");
                choice = Main.IN.nextInt();
                Main.IN.nextLine();
            } catch (Exception e) {
                Main.IN.nextLine();
                choice = -1;
            }

            if (choice == 0)
                break;
            if (choice > 0 && choice <= getCommands().length) {
                selectedCommand = getCommands()[choice - 1];
                selectedCommand.execute();
                if (selectedCommand.getClass().getSimpleName().startsWith("Delete"))
                    return;
            }
        }
        setCommands(null);
    }

    protected void printMenu(Command[] commandArray, int firstCommandIndex){
        System.out.println(this.getMessage1());
        if(commandArray.length == firstCommandIndex)
            System.out.println(this.getMessage2());
        for (int i = 0; i < commandArray.length; i++)
            System.out.println("[" + (i + 1) + "] - " + commandArray[i]);
        System.out.println("[0] - Вийти");
    }

    protected abstract String getMessage1();
    protected abstract String getMessage2();

    public static Command[] createCommandArray() {return null;}

    public static Command[] getCommands() { return commands; }
    public static void setCommands(Command[] commands) { Menu.commands = commands; }
}
