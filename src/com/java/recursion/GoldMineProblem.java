package com.java.recursion;

public class GoldMineProblem {

    private Integer doTask(Integer[][] matrix, int row, int col, Integer[][] maxProfit, int sum) {
        if (row > matrix.length - 1)
            return sum;
        if (col > matrix[0].length - 1)
            return sum;
        if (row < 0 || col < 0)
            return sum;
        if (row == matrix.length - 1 && col == matrix[0].length - 1)
            return sum;
        else {
            if (maxProfit[row][col] != null) {
                return maxProfit[row][col];
            }
            else {
                int maxValue =
                        Math.max(
                                doTask(matrix, row, col + 1, maxProfit, sum + matrix[row][col]),
                                Math.max(
                                        doTask(matrix, row + 1, col + 1, maxProfit, sum + matrix[row][col])
                                        ,
                                        doTask(matrix, row - 1, col + 1, maxProfit, sum + matrix[row][col])));
                maxProfit[row][col] = maxValue;
                return maxValue;
            }
        }
    }

    public static void main(String[] args) {
        GoldMineProblem obj = new GoldMineProblem();
        Integer[][] matrix = { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } };
        Integer[][] maxProfit = new Integer[3][3];
        int SUM1 = obj.doTask(matrix, 0, 0, maxProfit, 0);
        int sum2 = obj.doTask(matrix, 1, 0, maxProfit, 0);
        int sum3 = obj.doTask(matrix, 2, 0, maxProfit, 0);
        ;

        System.out.println(obj.doTask(matrix, 0, 0, maxProfit, 0));
    }

}
