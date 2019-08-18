package com.java.array;

public class StockBuyAndSell {

    public static void main(String[] args) {
        StockBuyAndSell obj = new StockBuyAndSell();
        int[] array = { 7, 1, 5, 3, 6, 4 };
        System.out.println(obj.doTask(array));
    }

    private Integer doTask(int[] array) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minPrice) {
                minPrice = array[i];
            }
            else if (array[i] - minPrice > maxProfit) {
                maxProfit = array[i] - minPrice;
            }
        }
        return maxProfit;
    }
}