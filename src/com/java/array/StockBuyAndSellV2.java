package com.java.array;

public class StockBuyAndSellV2 {

    public static void main(String[] args) {
        StockBuyAndSellV2 obj = new StockBuyAndSellV2();
        int[] array = { 7, 1, 5, 3, 6, 4 };
        System.out.println(obj.doTask(array));
    }

    private Integer doTask(int[] array) {
        int maxProfit = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                maxProfit += array[i] - array[i - 1];
            }
        }
        return maxProfit;
    }
}
