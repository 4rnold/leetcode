package com.example.leetcode.No155_MinStack;

import java.util.LinkedList;

class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    LinkedList<Integer> linkedList =null;
    LinkedList<Integer> minStack = null;

    /** initialize your data structure here. */
    public MinStack() {
        linkedList = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }
    
    public void push(int x) {
//        linkedList.add(x);
        linkedList.push(x);
        Integer peek = minStack.peek();
        if (peek == null || x <= peek) {
            minStack.push(x);
        }
    }
    
    public void pop() {
        Integer pop = linkedList.pop();
        Integer peek = minStack.peek();
        if (pop.equals(peek)) {
            minStack.pop();
        }
    }
    
    public int top() {
        return linkedList.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */