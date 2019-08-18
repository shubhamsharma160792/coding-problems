package com.java.tree.traversal;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    static Scanner userInput = new Scanner(System.in);
    static int     chancesLeft = 10;
    public static void main(String[] args) {
        System.out.println("Enter a random number between 1 to 10");
        while (userInput.hasNext() && chancesLeft > 1) {
            if (userInput.hasNextInt()) {
                int randomNumber = getRandomNumber();
                int guessedNumber = userInput.nextInt();

                if (randomNumber == guessedNumber) {
                    System.out.println("You guessed it right baby!");
                    System.out.println("Guessed number is: " + guessedNumber);
                    System.out.println("Random number is: " + randomNumber);
                    printEndingScreenNote();
                    return;
                }
                else {
                    chancesLeft--;
                    System.out.println("Wrong guess! you have " + chancesLeft + " chances left");
                    System.out.println("Guessed number is: " + guessedNumber);
                    System.out.println("Random number is: " + randomNumber);
                }
            }
            else {
                System.out.println("Please for god sake enter integer this time.");
            }
        }
        printEndingScreenNote();
    }

    public static void printEndingScreenNote() {
        System.out.println("Thanks for playing!");
    }

    public static int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(10);
    }
}
