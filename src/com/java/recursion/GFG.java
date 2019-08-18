package com.java.recursion;

/*package whatever //do not write package name here */
import java.util.Scanner;

class GFG {
    private Integer doTask(Integer[][] matrix, int row, int col, Integer[][] maxProfit) {
        if (row > matrix.length - 1)
            return 0;
        if (col > matrix[0].length - 1)
            return 0;
        if (row == matrix.length - 1 && col == matrix[0].length - 1)
            return 1;
        else {
            if (maxProfit[row][col] != null) {
                return maxProfit[row][col];
            }
            else {
                int maxValue = Math
                        .max(doTask(matrix, row + 1, col + 1, maxProfit), doTask(matrix, row - 1, col + 1, maxProfit));
                maxProfit[row][col] = maxValue;
                return maxValue;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GFG obj = new GFG();
        int testCases = scan.nextInt();
        while (testCases-- > 0) {
            int m = scan.nextInt();
            int n = scan.nextInt();
            Integer[][] matrix = new Integer[m][n];
            Integer[][] maxProfit = new Integer[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                    maxProfit[i][j] = null;
                }
            }
            System.out.println(obj.doTask(matrix, 0, 0, maxProfit));
        }
    }
}