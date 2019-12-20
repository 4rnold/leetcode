package com.example.leetcode.No297_serialize_and_deserialize_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
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
public class Codec {

    public static void main(String[] args) {
        Codec codec = new Codec();
//        TreeNode deserialize = codec.deserialize("[1,2,3,null,null,4,5]");
        System.out.println();

        System.out.println(codec.serialize(null));

        TreeNode deserialize = codec.deserialize("[5,2,3,null,null,2,4,3,1]");
        System.out.println();

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.addLast(root);
        ArrayList<String> list = new ArrayList<>();
        while (treeNodes.size() > 0) {
            TreeNode node = treeNodes.pollFirst();
            if (node == null) {
                list.add("null");
            } else {
                list.add(String.valueOf(node.val));
            }
            if (node != null) {
                TreeNode left = node.left;
                TreeNode right = node.right;
                treeNodes.addLast(left);
                treeNodes.addLast(right);
            }
        }
        int endIdx = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            String s = list.get(i);
            if (!s.equals("null")) {
                endIdx = i;
                break;
            }
        }
        List<String> strings = list.subList(0, endIdx + 1);

        String join = String.join(",", strings);
        return "[" + join + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.replaceAll("[\\[\\]]", "").split(",");
        if (split.length == 0 || split[0].length() == 0 || split[0].equals("null")) {
            return null;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        TreeNode node = new TreeNode(Integer.parseInt(split[0]));
        treeNodes.addLast(node);
        int idx = 1;
        while (treeNodes.size() > 0) {
            TreeNode node1 = treeNodes.pollFirst();
            int i = 2;
            while (node1!=null && i > 0 && idx < split.length) {
                String s = split[idx];
                TreeNode node2 = null;
                if (s.equals("null")) {
                    treeNodes.addLast(node2);
                } else {
                    node2 = new TreeNode(Integer.parseInt(s));
                    treeNodes.addLast(node2);
                }
                if (i == 2) {
                    node1.left = node2;
                } else if (i == 1) {
                    node1.right = node2;
                }
                idx++;
                i--;
            }
        }
        return node;

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


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));