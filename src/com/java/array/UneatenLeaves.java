package com.java.array;

import java.util.Arrays;
import java.util.HashSet;

public class UneatenLeaves {

    public int countUneatenLeaves(int N, int[] array) {
        int uneatenLeaves = 0;
        int size = array.length;
        int countEaten = 0;
        Arrays.sort(array);
        if (array[0] == 1) {
            return 0;
        }
        HashSet<Integer> positionEatenHash = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int jumpingFactor = array[i];
            for (int j = 1; j * jumpingFactor <= N; j++) {
                if (!positionEatenHash.contains(array[i] * j)) {
                    positionEatenHash.add(array[i] * j);
                    countEaten++;
                }
            }
        }
        uneatenLeaves = N - countEaten;
        return uneatenLeaves;
    }

    public static void main(String[] args) {
        UneatenLeaves obj = new UneatenLeaves();
        int[] array = { 2, 3, 5 };
        System.out.println(obj.countUneatenLeaves(10, array));
    }
}
