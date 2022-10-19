package mobileconnection.command.companymenucommand;

import mobileconnection.command.Command;
import mobileconnection.mobilecompany.MobileCompany;

import static mobileconnection.service.CompanyService.*;

public class SortTariffCommand implements Command {
    @Override
    public void execute() {
        MobileCompany company = getCurrentCompany();
        company.sortTariffs();
        setCurrentCompany(company);
        overwriteCompany(company, company.getName());
        System.out.println("\nТарифи посортовано!");
    }

    public String toString(){
        return "Сортувати тарифи за абонплатою";
    }
}
