package com.java.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {

    static class TreeNode {
        int      data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private void doTask(TreeNode root, int level) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        System.out.print(root.data + " ");
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                temp = q.poll();
                if (temp == null)
                    return;
                if (temp != null)
                    System.out.print(temp.data + " ");
                q.add(null);
            }
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        LeftViewOfTree obj = new LeftViewOfTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        obj.doTask(root, 0);
    }

}
