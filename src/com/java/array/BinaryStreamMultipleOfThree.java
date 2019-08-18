package com.java.array;

import java.util.Scanner;

public class BinaryStreamMultipleOfThree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int x = 0;
            String number = scan.next();
            for (int j = 0; j < number.length(); j++) {
                x = 2 * x + Integer.parseInt(Character.toString(number.charAt(j)));
                x = x % 3;
            }
            if (x == 0)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

}
