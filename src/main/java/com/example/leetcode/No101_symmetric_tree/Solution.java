package com.example.leetcode.No101_symmetric_tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isSymmetric(TreeNode root) {

        List<String> res = new ArrayList<>();
        foo(res, root,1);

        //判断对称
        for (int i = 0; i < res.size()/2; i++) {
            if (!res.get(i).equals(res.get(res.size()-1-i))) {
                return false;
            }
        }
        return true;

    }

    public static void foo(List<String> result, TreeNode node, int layer) {
        if (node == null) {
            result.add("a"+layer);
            return;
        }

        foo(result, node.left,layer+1);
        result.add(String.valueOf(node.val));
        foo(result, node.right,layer+1);
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