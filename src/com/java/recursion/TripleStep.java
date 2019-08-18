package com.java.recursion;

public class TripleStep {
    
    
    private Integer doTask(int n, Integer[] memo) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        else if (memo[n] != null) {
            return memo[n];
        }
        else {
            memo[n] = doTask(n - 1, memo) + doTask(n - 2, memo) + doTask(n - 3, memo);
            return memo[n];
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Integer[] memo = new Integer[n + 1];
        TripleStep obj = new TripleStep();
        System.out.printf("No. of ways: %d", obj.doTask(n, memo));
    }

}
