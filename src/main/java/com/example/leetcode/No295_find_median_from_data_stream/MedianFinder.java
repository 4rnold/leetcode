package com.example.leetcode.No295_find_median_from_data_stream;

import java.util.ArrayList;
import java.util.LinkedList;

class MedianFinder {
    private double sum = 0;
    private double count = 0;
    private Node headNode;

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(6);
        obj.addNum(10);
        obj.addNum(2);
        obj.addNum(6);
        obj.addNum(5);
        obj.addNum(0);
        System.out.println(obj.findMedian());
//        obj.addNum(3);
//        System.out.println(obj.findMedian());
    }


    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        sum = 0;
        count = 0;
//        LinkedList<Integer> integers = new LinkedList<>();
        headNode = new Node();
    }

    public void addNum(int num) {
        count++;
        sum = sum + num;

        Node node = new Node(num);
        Node tmpNode = headNode;
        while (tmpNode.next != null) {
            if (tmpNode.next.val > num) {
                //插入node
                Node t = tmpNode.next;
                tmpNode.next = node;
                node.next = t;
                return;
            } else {
                tmpNode = tmpNode.next;
            }
        }
        tmpNode.next = node;
    }

    public double findMedian() {
        if (count % 2 == 1) {
            int i = (int) (count / 2);
            Node n = headNode.next;
            while (i > 0) {
                n = n.next;
                i--;
            }
            if (n == null) {
                return 0;
            } else {
                return n.val;
            }
        } else {
            int v = (int) (count / 2);
            Node n = headNode.next;
            while (v-1 > 0) {
                n = n.next;
                v--;
            }
            double a  = n.val;
            double b = n.next.val;
            return (a + b) / 2;
        }
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */