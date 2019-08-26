package com.java.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    private void swapNodes(TreeNode node) {
        if (node == null)
            return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    private void invertTree(TreeNode root) {
        if (root == null)
            return;
        swapNodes(root);
        invertTree(root.left);
        invertTree(root.right);
    }

    private void levelOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.data + " ");
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }

    public static void main(String[] args) {
        InvertBinaryTree obj = new InvertBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        obj.levelOrderTraversal(root);
        obj.invertTree(root);
        System.out.println();
        obj.levelOrderTraversal(root);
    }

}
