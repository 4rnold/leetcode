package com.example.leetcode.No104_maximum_depth_of_binary_tree;

import cn.hutool.core.codec.Rot;

import javax.swing.tree.TreeNode;

class Solution {

    public static void main(String[] args) {
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int right = maxDepth(root.right);
        int left = maxDepth(root.left);
        return left>right?left+1:right+1;
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