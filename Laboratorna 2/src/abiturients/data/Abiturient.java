package abiturients.data;

import abiturients.main.Main;

public class Abiturient {
    private long id;
    private String surname, name, middleName, address, phoneNumber;
    private double mark;

    public Abiturient(){
        try {
            System.out.print("ID абітурієнта: ");
            id = Main.input.in.nextLong();
            Main.input.in.nextLine();
            System.out.print("Прізвище: ");
            surname = Main.input.in.nextLine();
            System.out.print("Ім'я: ");
            name = Main.input.in.nextLine();
            System.out.print("По батькові: ");
            middleName = Main.input.in.nextLine();
            System.out.print("Адреса: ");
            address = Main.input.in.nextLine();
            System.out.print("Номер телефону: ");
            phoneNumber = Main.input.in.nextLine();
            System.out.print("Середній бал: ");
            mark = Main.input.in.nextDouble();
            Main.input.in.nextLine();
        }
        catch(Exception e){
            System.out.println("Помилка типу даних при введенні!");
            System.exit(1);
        }
    }

    public String toString(){
        return "ID: " + id + ", Ініціали: " + surname + " " + name + " " + middleName + ", середній бал: " + mark + "\n";
    }

    //setters

    public void setAddress(String address) {
        this.address = address;
    }
    public void setMark(double mark) {
        this.mark = mark;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //getters

    public String getAddress() {
        return address;
    }
    public double getMark() {
        return mark;
    }
    public long getId() {
        return id;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getSurname() {
        return surname;
    }
}
