package com.java.array;

public class MaxProd {

    private Integer doTask(int[] A) {
        int[] leftMaxValueArray = new int[A.length];
        int[] rightMaxValueArray = new int[A.length];
        int maxProduct = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j && A[j] > A[i] && j < i)
                    leftMaxValueArray[i] = A[j];
                if (i != j && A[j] > A[i] && j > i)
                    rightMaxValueArray[i] = A[j];
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j && A[j] > A[i] && j > i) {
                    rightMaxValueArray[i] = A[j];
                    break;
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            int prod = leftMaxValueArray[i] * rightMaxValueArray[i];
            if (prod > maxProduct) {
                maxProduct = prod;
            }
        }
        return maxProduct;
    }
    public static void main(String[] args) {
        MaxProd obj = new MaxProd();
        int[] array = { 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9 };
        System.out.println(obj.doTask(array));
    }

}
