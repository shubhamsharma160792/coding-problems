package com.java.sliding.window;

import java.util.HashMap;

public class DistinctNumberInWindow {

    private int[] doTask(int[] array, int k) {
        int[] result = new int[array.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int distinct = 0;
        for (int i = 0; i < array.length; i++) {
            if (i >= k) {
                int prev = array[i - k];
                int val = map.getOrDefault(prev, 0);
                map.put(prev, val - 1);
                if (map.get(prev) == 0) {
                    map.remove(prev);
                    distinct--;
                }
            }
            int current = array[i];
            int val = map.getOrDefault(current, 0);
            map.put(current, val + 1);
            if (map.get(current) == 1)
                distinct++;
            if (i >= k - 1) {
                result[i - k + 1] = distinct;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        

        DistinctNumberInWindow obj = new DistinctNumberInWindow();
        int[] array = { 1, 2, 1, 3, 4, 3 };
        int[] result = obj.doTask(array, 3);
        for (int i : result)
            System.out.print(i + " ");
    }

}
