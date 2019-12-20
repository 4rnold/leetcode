package com.example.leetcode.No116_populating_next_right_pointers_in_each_node;

import cn.hutool.json.JSONUtil;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.LinkedList;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        Solution solution = new Solution();
        Node connect = solution.connect(node1);
        System.out.println();
    }

    public Node connect(Node root) {
        LinkedList<Node> linkedList = new LinkedList();
        Node preNode = root;
        linkedList.add(root);

        while (linkedList.size() != 0) {
            linkedList.add(null);
            int size = linkedList.size();
            while (size-- > 0) {
                Node poll = linkedList.poll();
                if (preNode != null) {
                    preNode.next = poll;
                }
                preNode = poll;
                if (poll != null) {
                    linkedList.add(poll.left);
                    linkedList.add(poll.right);
                }
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}