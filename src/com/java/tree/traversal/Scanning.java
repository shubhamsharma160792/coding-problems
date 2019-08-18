package com.java.tree.traversal;

import java.util.Scanner;

public class Scanning {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        if (userInput.hasNextInt()) {
            System.out.println(userInput.next());
            System.out.println(Math.round(6.5));

        }
    }
}