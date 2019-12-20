package com.example.leetcode.addtwonumbers;

import java.io.Serializable;

public class ListNode implements Serializable {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}