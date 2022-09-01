package abiturients.data;

import abiturients.main.Main;

public class Abiturient implements Comparable<Abiturient> {
    private long id;
    private String surname, name, middleName, address, phoneNumber;
    private double mark;

    public Abiturient(){
        inputFromKeyboard();
    }

    private void inputFromKeyboard(){
        try {
            System.out.print("ID абітурієнта: ");
            id = Main.input.getIn().nextLong();
            Main.input.getIn().nextLine();
            System.out.print("Прізвище: ");
            surname = Main.input.getIn().nextLine();
            System.out.print("Ім'я: ");
            name = Main.input.getIn().nextLine();
            System.out.print("По батькові: ");
            middleName = Main.input.getIn().nextLine();
            System.out.print("Адреса: ");
            address = Main.input.getIn().nextLine();
            System.out.print("Номер телефону: ");
            phoneNumber = Main.input.getIn().nextLine();
            System.out.print("Середній бал: ");
            mark = Main.input.getIn().nextDouble();
            Main.input.getIn().nextLine();
        }
        catch(Exception e){
            System.out.println("Помилка типу даних при введенні!");
            System.exit(1);
        }
    }

    public String toString(){
        return "ID: " + id + ", Ініціали: " + surname + " " + name + " " + middleName + ", середній бал: " + mark + "\n";
    }

    @Override
    public int compareTo(Abiturient other) {
        return Double.compare(other.getMark(), getMark());
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
