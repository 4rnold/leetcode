package com.example.leetcode.No138_copy_list_with_random_pointer;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {

    public static void main(String[] args) {

        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        node1.next = node2;
//        node1.random = node2;
//        node2.random = node2;


        Solution solution = new Solution();
        Node node = solution.copyRandomList(node1);
        System.out.println(JSONUtil.toJsonStr(node));
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        //hashcode -> 第几个node
        HashMap<Integer, Integer> map = new HashMap<>();

//        ArrayList<Node> oldNodeList = new ArrayList<>();
        ArrayList<Node> newNodeList = new ArrayList<>();

        Node originNode = head;
        Node resultHead = new Node();
        Node rTail = resultHead;
        int num = 0;
        while (originNode != null) {
//            oldNodeList.add(originNode);
//            int i = originNode.hashCode();
            map.put(originNode.hashCode(), num);
            Node newNode = new Node(originNode.val, null, null);
            rTail.next = newNode;
            rTail = newNode;
            newNodeList.add(newNode);
            originNode = originNode.next;
            num++;
        }

        Node oldNode = head;
        Node newNode = resultHead.next;
        while (oldNode != null) {
            Node random = oldNode.random;
            //获取关联的第几个节点
            if (random != null) {
                int hashcode = random.hashCode();
                Integer integer = map.get(hashcode);
                Node node = newNodeList.get(integer);
                newNode.random = node;
            } else {
                newNode.random = null;
            }
            newNode = newNode.next;
            oldNode = oldNode.next;
        }
        return resultHead.next;

    }

//    public static Node cloneNode(Node node) {
//        Node node1 = new Node();
//    }



    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }


    }
}