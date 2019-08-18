package com.java.stack;

import java.util.Stack;

public class NearestSmallerElement {

    private Integer[] doTask(int[] array) {
        Stack<Integer> s = new Stack<>();
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            while (!s.isEmpty() && s.peek() >= array[i])
                s.pop();
            if (s.isEmpty()) {
                result[i] = -1;
            }
            else {
                result[i] = s.peek();
            }
            s.push(array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        NearestSmallerElement obj = new NearestSmallerElement();
        int[] array = { 4, 5, 2, 10, 8 };
        Integer[] result = obj.doTask(array);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
