package com.java.stack;

import java.util.Stack;

class MinStack {

    private Stack<Integer> s        = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        s.clear();
        minStack.clear();
    }

    public void push(int x) {
        s.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        }
        else {
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (s.isEmpty() || minStack.isEmpty()) {
            return;
        }
        int top = s.pop();
        if (top == minStack.peek())
            minStack.pop();
    }

    public int top() {
        if (s.isEmpty())
            return -1;
        return s.peek();
    }

    public int getMin() {
        if (minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}
