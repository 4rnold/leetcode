package com.example.leetcode.No102_binary_tree_level_order_traversal;

import javax.sound.midi.Soundbank;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        Integer first = ((LinkedList<Integer>) queue).getFirst();
        Integer last = ((LinkedList<Integer>) queue).getLast();
        System.out.println(first);
        System.out.println(last);

        Integer poll = queue.poll();
        System.out.println(poll);

        Integer poll2 = queue.poll();
        System.out.println(poll2);

        Integer pop = ((LinkedList<Integer>) queue).pop();
        System.out.println(pop);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> result = new ArrayList<>();

        while (queue.size() > 0) {
            List<Integer> oneline = new ArrayList<>();
            for (TreeNode treeNode : queue) {
                if (treeNode != null) {
                    oneline.add(treeNode.val);
                }
            }
            if (oneline.size() > 0) {
                result.add(oneline);
            }

            int size = queue.size();

            while (size>0) {
                TreeNode first = ((LinkedList<TreeNode>) queue).poll();
                if (first != null) {
                    queue.offer(first.left);
                    queue.offer(first.right);
                }
            }
        }
        return result;
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