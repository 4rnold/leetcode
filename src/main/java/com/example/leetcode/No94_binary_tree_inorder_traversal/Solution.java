package com.example.leetcode.No94_binary_tree_inorder_traversal;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        foo(res, root);
        return res;
    }

    public static void foo(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        foo(result, node.left);
        result.add(node.val);
        foo(result, node.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}