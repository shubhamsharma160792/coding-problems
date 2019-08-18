package com.java.recursion;

import java.util.Scanner;

public class Fibonacci {

    private int generateFibonacciSequence(int num) {
        if (num == 1 || num == 2)
            return 1;
        return generateFibonacciSequence(num - 1) + generateFibonacciSequence(num - 2);
    }

    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter numbers to print fibonacci sequence");
        int number = scan.nextInt();
        for (int i = 1; i <= number; i++) {
            System.out.format(" %d", obj.generateFibonacciSequence(i));
        }

    }

}
