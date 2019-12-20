package com.example.leetcode.No105_buildTree;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int thisNodeVal = preorder[0];
        TreeNode thisNode = new TreeNode(thisNodeVal);

        int m = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == thisNodeVal) {
                m = i;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, m);
        int[] rightInorder = Arrays.copyOfRange(inorder, m + 1, inorder.length);

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length);


        thisNode.left = buildTree(leftPreorder, leftInorder);
        thisNode.right = buildTree(rightPreorder, rightInorder);
        return thisNode;
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