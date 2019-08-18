package com.java.recursion;

public class WaysToTileFloor {

    private Long doTask(int n, Long[] array) {
        if (n < 0)
            return 0L;
        if (n == 0)
            return 1L;
        if (array[n] != null) {
            return array[n];
        }
        else {
            Long val = doTask(n - 1, array) + doTask(n - 2, array);
            array[n] = val;
            return val;
        }
    }

    public static void main(String[] args) {
        WaysToTileFloor obj = new WaysToTileFloor();
        int n = 10;
        System.out.println(obj.doTask(n, new Long[n + 1]));
    }

}
