package com.java.stack;

import java.util.Stack;

public class ReversePolishNotation {

    private Integer doTask(String[] notation) throws Exception {
        String operators = "+-*/";
        Stack<String> s = new Stack<>();
        for (String token : notation) {
            if (!operators.contains(token)) {
                s.push(token);
            }
            else {
                int a = Integer.valueOf(s.pop());
                int b = Integer.valueOf(s.pop());
                int val = operators.indexOf(token);
                switch (val) {
                    case 0:
                        s.add(String.valueOf(a + b));
                        break;
                    case 1:
                        s.add(String.valueOf(a-b));
                        break;
                    case 2: 
                        s.add(String.valueOf(a*b));
                        break;
                    case 3:
                        s.add(String.valueOf(a/b));
                        break;
                    default:
                        System.out.println("Invalid expression");
                        throw new Exception();
                }
            }
        }
        return Integer.valueOf(s.pop());
    }
    public static void main(String[] args) {
        ReversePolishNotation obj = new ReversePolishNotation();
        String[] notation = new String[] { "2", "1", "+", "3", "*", "*" };
        try {
            System.out.println(obj.doTask(notation));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
