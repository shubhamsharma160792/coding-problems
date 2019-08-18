package com.java.array;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenDifference {

    public static void main(String[] args) {
        CountPairsWithGivenDifference obj = new CountPairsWithGivenDifference();
        int[] array = { 1, 1, 1 };
        int k = 0;
        System.out.println(obj.doTask(array, k));
    }

    private Integer doTask(int[] array, int k) {
        int size = array.length;
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int val = map.getOrDefault(array[i], 0);
            map.put(array[i], val + 1);
        }
        for (int i = 0; i < size; i++) {
            if (k == 0 && map.containsKey(array[i]) && map.get(array[i]) > 1) {
                counter++;
                map.remove(array[i]);
            }
            else if (k != 0 && map.containsKey(k + array[i])) {
                counter++;
                map.remove(k + array[i]);
            }
        }
        return counter;
    }
}
