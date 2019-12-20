package com.example.leetcode.No230_kth_smallest_element_in_a_bst;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static int count = 0;
    public static TreeNode kMinNode = null;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        kMinNode = null;
        foo(root, k);
        return kMinNode.val;
    }

    public static void foo(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }
        foo(node.left, k);
        count++;
        if (count == k) {
            kMinNode = node;
            return;
        }
        foo(node.right,k);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}