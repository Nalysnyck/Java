package mobileconnection.command.companymenucommand;

import mobileconnection.command.Command;

import static mobileconnection.menu.MainMenu.createMainCommandArray;
import static mobileconnection.menu.MenuUtils.IN;
import static mobileconnection.menu.MenuUtils.setCommands;
import static mobileconnection.service.CompanyService.deleteCompany;
import static mobileconnection.service.CompanyService.getCurrentCompany;

public class DeleteCompanyCommand implements Command {
    @Override
    public void execute() {
        int choice;
        System.out.print("\nБажаєте видалити мобільну компанію \"" + getCurrentCompany().getName() + "\"?"
                + "\n\t1. Так"
                + "\n\t2. Ні"
                + "\nВаш вибір >>> ");
        choice = IN.nextInt();
        if (choice == 1)
            deleteCompany(getCurrentCompany());

        setCommands(createMainCommandArray());
    }

    public String toString(){
        return "Видалити мобільну компанію";
    }
}
