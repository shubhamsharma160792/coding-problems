package com.java.recursion;

import java.util.Scanner;

public class FibonacciSequence {

    private static int fibonacci(int x) {
        if (x == 0 || x == 1) {
            return 1;
        }
        return fibonacci(x - 1) + fibonacci(x - 2);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of fibonacci sequence to print: ");
        int number = scan.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
