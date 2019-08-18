package com.java.array;

public class ContainerWithMostWater {

    private Integer doTask(int[] array) {
        int max = Integer.MIN_VALUE;
        int i = 0, j = array.length - 1;
        int min = 0;
        while (i < j) {
            min = Math.min(array[i], array[j]);
            max = Math.max(max, min * (j - i));
            if (array[i] < array[j])
                i++;
            else
                j--;
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int[] array = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(obj.doTask(array));
    }

}
