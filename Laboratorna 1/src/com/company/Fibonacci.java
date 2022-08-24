package com.company;

public class Fibonacci {
    public static long getFibNum(int order){
        long number = 1, nextNumber = 1;
        while (--order > 0){
            nextNumber += number;
            number = nextNumber - number;
        }
        return number;
    }
}
