package com.java.tree.traversal;

import java.util.HashMap;
import java.util.Map;

public class Zalando {

    private void doTask() {

    }

    public static void main(String[] args) {
        Zalando obj = new Zalando();
        System.out.println("Result issss" + obj.solution(2, 65536));
    }

    public int solution(int A, int B) {
        // write your code in Java SE 8
        int max = 0;
        for (int i = A; i <= B; i++) {
            int count = countNumberOfSquareRoot(i);
            if(max<count){
                max=count;
            }
        }
       return max;
        
    }

    private int countNumberOfSquareRoot(int i) {
        // TODO Auto-generated method stub
        int count = 0;
        double res = i;
        while (res > 1) {

            res = Math.sqrt(res);
            double check = res % 1;
            if (check == 0) {

                count++;
            }
            else {
                break;
            }
        }
        // System.out.println(count);
        return count;
    }

}
