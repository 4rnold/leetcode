package com.example.leetcode.No124_binary_tree_maximum_path_sum;


import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    static Integer totalMax = Integer.MIN_VALUE;
    public static void main(String[] args) {
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE - 1);
    }
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        ArrayList<Integer> objects = new ArrayList<>();
        int thiss = root.val;
        objects.add(thiss);
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        //传递给父节点不用传单独的子节点。
//        objects.add(left);
//        objects.add(right);
        if (left > 0) {
            int leftThis = left + root.val;
            objects.add(leftThis);
        }
        if (right > 0) {
            int rightThis = right + root.val;
            objects.add(rightThis);
        }
        int leftRightThis = Integer.MIN_VALUE;
        if (right > 0 && left > 0) {
            leftRightThis = left + right + root.val;
//            objects.add(leftRightThis);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < objects.size() ; i++) {
            if (objects.get(i) > max) {
                max = objects.get(i);
            }
        }

        //比较全局的时候要比较left right 子节点
        int m = Math.max(Math.max(left,right),Math.max(max,leftRightThis));
        if (m > totalMax) {
            totalMax = m;
        }

        return max;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}