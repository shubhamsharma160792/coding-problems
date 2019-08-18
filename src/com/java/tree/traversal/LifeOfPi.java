package com.java.tree.traversal;

import java.util.Scanner;

public class LifeOfPi {
    
    //Input threshold limit from user
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter integer threshold value for lifeOfPi");
        // 4 - 4/3 + 4/5 - 4/7 + ....
        if (!userInput.hasNextInt()) {
            System.out.println("Please enter an integer value");
            return;
        }

        int iterator = 1;
        final double NUM = 4;
        double result = NUM;
        int flag = -1;
        int threshold = userInput.nextInt();

        while (iterator <= threshold) {
            if (iterator % 2 == 1) {
                double deltaValue = (NUM / (iterator + 2));
                if (flag == -1) {
                    result = result - deltaValue;
                    flag = 1;
                }
                else if (flag == 1) {
                    result = result + deltaValue;
                    flag = -1;
                }
            }
            iterator += 1;
        }
        System.out.println("final result value: " + result);

    }
}
