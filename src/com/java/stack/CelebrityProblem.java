package com.java.stack;

import java.util.Stack;

public class CelebrityProblem {

    public static void main(String[] args) {
        CelebrityProblem obj = new CelebrityProblem();
        int matrix[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };
        System.out.println(obj.doTask(matrix, 4));
    }

    private boolean knows(int[][] matrix, int a, int b) {
        return matrix[a][b] == 1 ? true : false;
    }

    private Integer doTask(int[][] matrix, int n) {
        Stack<Integer> s = new Stack<>();
        for(int i=0; i < n;i++){
            s.push(i);
        }
        while(s.size() >1){
            int a = s.pop();
            int b = s.pop();
            if(knows(matrix, a, b)){
                s.push(b);
            }else{
                s.push(a);
            }
        }
        int c = s.pop();
        return c;
    }

}
