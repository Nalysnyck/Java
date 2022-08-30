package abiturients.main;

import abiturients.data.Abiturient;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("***Створення масиву абітурієнтів***");

        Abiturient[] abiturients = createArray();

        findAndPrintByName(abiturients);

        findAndPrintHigherThanMark(abiturients);

        findAndPrintAbiturientsWithHighestMarks(abiturients);
    }

    public static class input {
        public static Scanner in = new Scanner(System.in);
    }

    public static Abiturient[] createArray(){
        int objectsNumber = 0;

        try {
            System.out.print("Введіть кількість студентів: ");
            objectsNumber = input.in.nextInt();
            input.in.nextLine();
        }
        catch (Exception e){
            System.out.println("Помилка типу даних при введенні!");
        }

        Abiturient[] objects = new Abiturient[objectsNumber];

        for (int i = 0; i < objectsNumber; i++) {
            System.out.print(i + 1 + ". ");
            objects[i] = new Abiturient();
        }

        return objects;
    }

    public static void findAndPrintByName(Abiturient[] abiturients){
        System.out.print("Введіть ім'я абітурієнтів, котрих хочете знайти: ");

        String name = null;

        try {
            name = input.in.nextLine();
        }
        catch (Exception e){
            System.out.println("Помилка при введенні!");
        }

        System.out.println("Абітурієнти з цим іменем:");
        
        boolean isNeededAbiturients = false;

        for (Abiturient abiturient : abiturients) {
            if (Objects.equals(abiturient.getName(), name)) {
                System.out.print(abiturient);
                isNeededAbiturients = true;
            }
        }

        if (!isNeededAbiturients)
            System.out.println("Немає абітурієнтів із заданим іменем!");
    }

    public static void findAndPrintHigherThanMark(Abiturient[] abiturients){
        System.out.print("Введіть бал, абітурієнтів з вищим за який хочете знайти: ");

        double mark = 0;

        try {
            mark = input.in.nextDouble();
            input.in.nextLine();
        }
        catch (Exception e){
            System.out.println("Помилка при введенні!");
        }

        System.out.println("Абітурієнти із середнім балом, що більший за " + mark + ":");

        boolean isNeededAbiturients = false;

        for (Abiturient abiturient : abiturients) {
            if (abiturient.getMark() > mark) {
                System.out.print(abiturient);
                isNeededAbiturients = true;
            }
        }

        if (!isNeededAbiturients)
            System.out.println("Немає абітурієнтів із середнім балом вищим за заданий!");
    }

    public static void findAndPrintAbiturientsWithHighestMarks(Abiturient[] abiturients){
        System.out.print("Введіть к-сть абітурієнтів з найвищими балами, яких хочете знайти: ");

        sorting(abiturients);

        int amount = 0;

        try {
            amount = input.in.nextInt();
            input.in.nextLine();
            if(amount < 1){
                System.out.println("Неможливе число!");
                System.exit(1);
            }
        }
        catch (Exception e){
            System.out.println("Помилка при введенні!");
        }

        for (int k = 0; k < amount; k++) {
            System.out.print(abiturients[k]);
        }
    }
    public static void sorting(Abiturient[] abiturients){
        for (int i = 0; i < abiturients.length; i++) {
            for (int j = i + 1; j < abiturients.length; j++) {
                Abiturient temp;
                if (abiturients[j].getMark() > abiturients[i].getMark()) {
                    temp = abiturients[i];
                    abiturients[i] = abiturients[j];
                    abiturients[j] = temp;
                }
            }
        }
    }
}