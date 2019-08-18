package com.java.stack;

import java.util.Stack;

public class ValidParenthesis {

    private boolean doTask(String input) {
        if (input.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < input.length(); i++){
            if (isValidInput(input.charAt(i))) {
                if(input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[')
                    stack.push(input.charAt(i));
                else if (stack.isEmpty())
                    return false;
                else {
                    Character bracketToCompare = stack.pop();
                    if (input.charAt(i) == ')' && bracketToCompare != '(')
                        return false;
                    if (input.charAt(i) == '}' && bracketToCompare != '{')
                        return false;
                    if (input.charAt(i) == ']' && bracketToCompare != '[')
                        return false;
                }
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }

    private boolean isValidInput(char c) {
        if (c == '(' || c == ')')
            return true;
        if (c == '{' || c == '}')
            return true;
        if (c == '[' || c == ']')
            return true;
        return false;
    }

    public static void main(String[] args) {
        ValidParenthesis obj = new ValidParenthesis();
        String input = "[]";
        System.out.printf("Valid Parenthesis:  %b ", obj.doTask(input));

    }

}
