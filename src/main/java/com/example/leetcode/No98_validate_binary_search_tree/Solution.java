package com.example.leetcode.No98_validate_binary_search_tree;

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
    public boolean isValidBST(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        foo(res, root);

        //判断大小

        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) < res.get(i - 1)) {
                return false;
            }
        }
        return true;

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