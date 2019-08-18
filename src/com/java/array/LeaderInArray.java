package com.java.array;
import java.util.Stack;

public class LeaderInArray {

    private void doTask(int[] array) {
        int max = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > max) {
                s.push(array[i]);
                max = array[i];
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args) {
        LeaderInArray obj = new LeaderInArray();
        int[] array = { 7, 4, 5, 7, 3 };
        obj.doTask(array);
        System.out.println();
    }

}
