package com.mobileconnection.command.companymenucommand;

import com.mobileconnection.MyLogger;
import com.mobileconnection.command.Command;
import com.mobileconnection.mobilecompany.MobileCompany;

import static com.mobileconnection.service.CompanyService.*;

public class SortTariffCommand implements Command {
    @Override
    public void execute() {
        MobileCompany company = getCurrentCompany();
        company.sortTariffs();
        setCurrentCompany(company);
        overwriteCompany(company, company.getName());
        System.out.println("\nТарифи посортовано!");
        MyLogger.logger.info("Тарифи компанії \"" + company.getName() + "\" посортовано");
    }

    public String toString(){
        return "Сортувати тарифи за абонплатою";
    }
}
