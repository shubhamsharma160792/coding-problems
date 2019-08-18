package com.java.array;

import java.util.Scanner;

public class FindPerfectSquares {

    private int findPerfectSquares(int from, int to) {
        int i = from;
        int counter = 0;
        while (i <= to) {
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i)
                    counter++;
            }
            i++;
        }
        return counter;
    }

    private double findPerfectSquaresOptimized(int from, int to) {
        return Math.floor(Math.sqrt(to)) - Math.floor(Math.sqrt(from)) + 1;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two numbers");
        int from = scan.nextInt();
        int to = scan.nextInt();
        FindPerfectSquares obj = new FindPerfectSquares();
        System.out.format(
                "Perfect squares between two numbers %d and %d is %d \n",
                from,
                to,
                obj.findPerfectSquares(from, to));
        System.out.format(
                "Perfect squares between two numbers %d and %d is %d \n",
                from,
                to,
                (int) obj.findPerfectSquaresOptimized(from, to));
    }
}
