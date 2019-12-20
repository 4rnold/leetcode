package com.example.leetcode.mergeKLists;

import cn.hutool.json.JSONUtil;
import com.example.leetcode.addtwonumbers.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
//        ListNode a = buildList(new int[]{1, 4, 5});
//        ListNode b = buildList(new int[]{1, 3, 4});
//        ListNode c = buildList(new int[]{2, 6});

        ListNode a = buildList(new int[]{1});
        ListNode b = buildList(new int[]{1});
        ListNode c = buildList(new int[]{2});

        ListNode[] nodes = new ListNode[]{a,b,c};

        ListNode listNode = mergeKLists(nodes);
        System.out.println(JSONUtil.toJsonStr(listNode));
    }

    public static ListNode buildList(int[] a) {
        ListNode firstNode = new ListNode(0);
        ListNode preNode = new ListNode(0);
        for (int i = 0; i < a.length; i++) {
            ListNode listNode = new ListNode(a[i]);

            if (i == 0) {
                firstNode = listNode;
                preNode = listNode;
            } else {
                preNode.next = listNode;
                preNode = listNode;
            }
        }

        return firstNode;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode resultHead = new ListNode(0);
        ListNode tail = resultHead;

        ListNode[] topNodes = lists;
        boolean allEmpty = false;
        while (allEmpty == false) {
            ListNode minNode = new ListNode(Integer.MAX_VALUE);
            int minIdx = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode topNode = topNodes[i];
                if (topNode != null) {
                    if (topNode.val <= minNode.val) {
                        minIdx = i;
                        minNode = topNode;
                    }
                }
            }

            if (minIdx == -1) {
                allEmpty = true;
            } else {
                //记录
                tail.next = new ListNode(minNode.val);
                tail = tail.next;
                topNodes[minIdx] = topNodes[minIdx].next;
            }
        }
        return resultHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}