package com.java.greedy;

import java.util.Arrays;

public class MinimumPlatformRequired {

    public static void main(String[] args) {
        MinimumPlatformRequired obj = new MinimumPlatformRequired();
        int[] arrival = { 900, 940, 950, 1100, 1500, 1800 };
        int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };
        Arrays.sort(arrival);
        Arrays.sort(departure);
        System.out.println(obj.doTask(arrival, departure));
    }

    private Integer doTask(int[] arrival, int[] departure) {
        int platformNeeded = 1;
        int size = arrival.length;
        int i = 1, j = 0, totalPlatforms = 1;
        while (i < size && j < size) {
            if (arrival[i] <= departure[j]) {
                platformNeeded++;
                i++;
                if (totalPlatforms < platformNeeded)
                    totalPlatforms = platformNeeded;
            }
            else {
                platformNeeded--;
                j++;
            }
        }
        return totalPlatforms;
    }

}
