package com.java.recursion;

import java.util.Stack;

public class Test {

    private Stack<Integer> getDigits(int key) {
        Stack<Integer> digits = new Stack<>();
        while (key > 0) {
            digits.add(key % 10);
            key = key / 10;
        }
        return digits;
    }

    private String encryptString(String msg, int key) {
        StringBuilder output = new StringBuilder();
        Stack<Integer> digits = getDigits(key);
        int index = 0;
        while (!digits.isEmpty()) {
            int val = digits.pop();
            for (int i = 0; i < val; i++) {
                if (msg.length() > index)
                    output.append(msg.charAt(index));
            }
            index++;
        }
        output.append(msg.substring(index));
        return output.toString();
    }

    private String decryptString(String msg, int key) {
        StringBuilder output = new StringBuilder();
        Stack<Integer> digits = getDigits(key);
        int index = 0;
        while (!digits.isEmpty()) {
            int val = digits.pop();
            for (int i = 0; i < val; i++)
                index++;
            output.append(msg.charAt(index - 1));
        }
        output.append(msg.substring(index));
        return output.toString();
    }

    private String doTask(Integer operation, String msg, Integer key) {
        if(operation != 1 && operation !=2 )
            return null;
        if (msg == null || msg.length() < 1)
            return null;
        if(key == null)
            return null;
        String output = null;
        switch (operation) {
            case 1:
                output = encryptString(msg, key);
                break;
            case 2:
                output = decryptString(msg, key);
                break;
        }
        return output;
    }
    public static void main(String[] args) {
        Test obj = new Test();
        int operation = 1;
        String msg = "Ope";
        int key = 12345;
        String opt = obj.doTask(operation, msg, key);
        if (opt == null)
            System.out.println(-1);
        else
            System.out.println(opt);
    }
}
