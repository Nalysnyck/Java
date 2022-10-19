package mobileconnection.service;

import mobileconnection.mobilecompany.MobileCompany;
import mobileconnection.tariff.Tariff;

import java.io.*;

public class CompanyService {
    private static MobileCompany currentCompany;
    private static Tariff currentTariff;
    private static final File appFolder = new File(System.getProperty("user.home") + "\\AppData\\Local\\MobileConnection");
    private static final File companiesFolder = new File(appFolder.getAbsolutePath() + "\\companies");
    public static MobileCompany[] getCompanyArray() {
        int filesNumber = 0;
        if (!companiesFolder.exists())
            return null;

        File[] files = companiesFolder.listFiles();
        if (files == null) return null;

        for (File file : files)
            if (file.isFile()) filesNumber++;

        if (filesNumber == 0) return null;
        MobileCompany[] companies = new MobileCompany[filesNumber];

        for (int i = 0; i < filesNumber; ) {
            if (files[i].isFile()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(files[i]);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    companies[i] = (MobileCompany) objectInputStream.readObject();
                    objectInputStream.close();
                    fileInputStream.close();
                } catch (Exception e) {
                    System.out.println("Помилка читання файлу " + files[i].getName());
                    return null;
                }
                i++;
            }
        }
        return companies;
    }

    public static void addCompany(MobileCompany mobileCompany){
        if(!appFolder.exists())
            appFolder.mkdirs();
        if(!companiesFolder.exists())
            companiesFolder.mkdir();

        File file = new File(companiesFolder.getAbsolutePath() + "\\" + mobileCompany.getName() + ".dat");
        if(file.exists())
            System.out.println("Мобільна компанія з такою назвою вже існує!");
        else {
            try {
                if (!file.createNewFile())
                    throw new Exception();

                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(mobileCompany);
                objectOut.flush();
                objectOut.close();
                fileOut.close();

            } catch (Exception e) {
                System.out.println("Помилка при створенні файлу " + file.getName());
            }
        }
    }

    public static void overwriteCompany(MobileCompany company, String oldName){
        setCurrentCompany(company);
        File oldFile = new File(companiesFolder.getAbsolutePath() + "\\" + oldName + ".dat");
        if(!oldFile.exists())
            System.out.println("Такої мобільної компанії не існує!");
        else {
            oldFile.delete();
            addCompany(getCurrentCompany());
        }
    }

    public static void deleteCompany(MobileCompany company){
        if(!companiesFolder.exists()) return;

        File file = new File(companiesFolder.getAbsolutePath() + "\\" + company.getName() + ".dat");
        if(file.exists()) {
            if(!file.delete())
                System.out.println("Помилка при видаленні файлу " + file.getName());
            else
                System.out.println("Файл " + file.getName() + " успішно видалено!");
        }
    }

    public static void setCurrentCompany(MobileCompany company) {currentCompany = company;}
    public static MobileCompany getCurrentCompany() {return currentCompany;}

    public static void setCurrentTariff(Tariff tariff) {currentTariff = tariff;}
    public static Tariff getCurrentTariff() {return currentTariff;}
}