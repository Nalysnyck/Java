package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int order = 0;

        try {
            if (args.length == 0){
                System.out.println("Input N-number of Fibonacci series: ");
                Scanner sc = new Scanner(System.in);
                order = sc.nextInt();
                sc.close();
            }
            else order = Integer.parseInt(args[0]);
        }
        catch (Exception e){
            System.out.println("Error has occured!");
            System.exit(1);
        }

        if (order < 1) {
            System.out.println("This number is illegal!");
            System.exit(1);
        }

        double powNum = Math.pow(1.75, order);

        System.out.printf("\n%d number of Fibonacci series is %d and it`s %s than 1.75^N (%f)", order,
                Fibonacci.getFibNum(order), Fibonacci.getFibNum(order) > powNum? "bigger" : "lower", powNum);
    }
}