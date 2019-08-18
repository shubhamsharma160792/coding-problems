package com.java.recursion;

import java.util.concurrent.TimeUnit;

public class RecursionWithAndWithoutMemoization {

    public static void main(String[] args) {
        RecursionWithAndWithoutMemoization obj = new RecursionWithAndWithoutMemoization();
        long startTime = System.nanoTime();
        System.out.println(obj.fibRecursive(5));
        long endTime = System.nanoTime();
        long duration = TimeUnit.MICROSECONDS.toMillis(endTime - startTime);
        System.out.printf("Time taken to compute fib(20) with recursion: " + duration + " micro seconds");
        System.out.println();
        startTime = System.nanoTime();
        System.out.println(obj.doTask(5, new Integer[35]));
        endTime = System.nanoTime();
        duration = TimeUnit.MICROSECONDS.toMillis(endTime - startTime);
        System.out
                .printf("Time taken to compute fib(20) with recursion and memoization: " + duration + " micro seconds");
    }

    private Integer fibRecursive(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;
        return fibRecursive(i - 1) + fibRecursive(i - 2);
    }

    private Integer doTask(int i, Integer[] array) {
        if (i == 0 || i == 1)
            return i;
        if (array[i - 1] != null) {
            return array[i - 1];
        }
        else {
            int val = doTask(i - 1, array) + doTask(i - 2, array);
            array[i - 1] = val;
            return val;
        }
    }
}
