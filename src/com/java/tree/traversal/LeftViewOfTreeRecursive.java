package com.java.tree.traversal;

public class LeftViewOfTreeRecursive {

    static int max_level = 0;
    static class TreeNode {
        int      data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private void printLeftView(TreeNode root, int level) {
        if (root == null)
            return;
        if (max_level < level) {
            System.out.print(root.data);
            max_level = level;
        }
        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);
    }

    private void doTask(TreeNode root) {
        printLeftView(root, 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        LeftViewOfTreeRecursive obj = new LeftViewOfTreeRecursive();
        obj.doTask(root);
    }

}
