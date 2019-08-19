package com.java.tree.traversal;


public class MinDepthOfBinaryTree {

    private int doTask(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int leftDepth = root.left != null ? doTask(root.left) : Integer.MAX_VALUE;
        int rightDepth = root.right != null ? doTask(root.right) : Integer.MAX_VALUE;
        return 1 + Math.min(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        MinDepthOfBinaryTree obj = new MinDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        System.out.printf("Min depth %d", obj.doTask(root));
    }

}
