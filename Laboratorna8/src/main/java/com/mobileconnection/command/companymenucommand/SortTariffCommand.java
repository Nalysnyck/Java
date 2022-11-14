package com.mobileconnection.command.companymenucommand;

import com.mobileconnection.command.Command;
import com.mobileconnection.mobilecompany.MobileCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mobileconnection.service.CompanyService.*;

public class SortTariffCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(SortTariffCommand.class);
    @Override
    public void execute() {
        MobileCompany company = getCurrentCompany();
        company.sortTariffs();
        setCurrentCompany(company);
        overwriteCompany(company, company.getName());
        System.out.println("\nТарифи посортовано!");
        logger.info("Тарифи компанії \"" + company.getName() + "\" посортовано");
    }

    public String toString(){
        return "Сортувати тарифи за абонплатою";
    }
}