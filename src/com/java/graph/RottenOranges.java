package com.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    static class Node {
        private int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }

    private Integer doTask(int A[][]) {
        int m = A.length;
        int n  = A[0].length;
        int days = -1;
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i< m; i++){
            for(int j=0; j < n; j++){
                if(A[i][j] == 2)
                    q.add(new Node(i,j));
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            while (size-- > 0) {
                Node node = q.poll();
                int row = node.getRow();
                int col = node.getCol();
                if (row - 1 >= 0 && A[row - 1][col] == 1) {
                    A[row - 1][col] = 2;
                    q.add(new Node(row - 1, col));
                }
                if (row + 1 < m && A[row + 1][col] == 1) {
                    A[row + 1][col] = 2;
                    q.add(new Node(row + 1, col));
                }
                if (col - 1 >= 0 && A[row][col - 1] == 1) {
                    A[row][col - 1] = 2;
                    q.add(new Node(row, col - 1));
                }
                if (col + 1 < n && A[row][col + 1] == 1) {
                    A[row][col + 1] = 2;
                    q.add(new Node(row, col + 1));
                }
            }
            days++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1)
                    return -1;
            }
        }
        return days;
    }

    public static void main(String[] args) {
        RottenOranges obj = new RottenOranges();
        int[][] A = { { 0, 2, 1 }, { 2, 2, 1 }, { 0, 1, 0 }, { 2, 1, 1 }, { 0, 1, 1 }, { 1, 2, 1 } };
        System.out.println(obj.doTask(A));
    }

}
