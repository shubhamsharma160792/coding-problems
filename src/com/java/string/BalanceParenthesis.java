package com.java.string;

import java.util.Stack;

public class BalanceParenthesis {

    private String doTask(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!stack.isEmpty()) {
                if (stack.peek().equals('{') && str.charAt(i) == '}') {
                    stack.pop();
                }
                else if (stack.peek().equals('(') && str.charAt(i) == ')') {
                    stack.pop();
                }
                else if (stack.peek().equals('[') && str.charAt(i) == ']') {
                    stack.pop();
                }
                else {
                    stack.push(str.charAt(i));
                }
            }
            else {
                stack.push(str.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return "balanced";
        }
        return "not balanced";
    }

    public static void main(String[] args) {
        BalanceParenthesis obj = new BalanceParenthesis();
        System.out.println(obj.doTask("(()"));
    }

}
