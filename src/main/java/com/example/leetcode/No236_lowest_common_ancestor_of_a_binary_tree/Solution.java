package com.example.leetcode.No236_lowest_common_ancestor_of_a_binary_tree;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.LinkedList;

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
    public static LinkedList<TreeNode> treeNodes = new LinkedList<>();
    public static LinkedList<TreeNode> treeNodes2 = new LinkedList<>();
    public static boolean pushNode1 = true;
    public static boolean pushNode2 = true;

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode2.left = treeNode1;
        Solution solution = new Solution();
        TreeNode treeNode = solution.lowestCommonAncestor(treeNode3, treeNode1, treeNode4);
        System.out.println();
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        treeNodes.clear();
        treeNodes2.clear();
        pushNode1 = true;
        pushNode2 = true;
        foo(root, p, q);
        TreeNode result = null;
        while (treeNodes.size() > 0 && treeNodes2.size() > 0) {
            TreeNode treeNode = treeNodes.pollLast();
            TreeNode treeNode2 = treeNodes2.pollLast();
            if (treeNode == treeNode2) {
                result = treeNode;
            } else {
                break;
            }
        }
        return result;
    }

    public static void foo(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || (pushNode1 == false && pushNode2 == false)) {
            return;
        }

        if (pushNode1 == true) {
            treeNodes.push(node);
        }
        if (pushNode2 == true) {
            treeNodes2.push(node);
        }

        if (p == node ) {
            pushNode1 = false;
        }

        if (q == node) {
            pushNode2 = false;
        }

        foo(node.left, p, q);
        foo(node.right, p, q);

        if (pushNode1 == true) {
            //1栈不动
            treeNodes.pop();
        }
        if (pushNode2 == true) {
            //1栈不动
            treeNodes2.pop();
        }

    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}