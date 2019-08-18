package com.java.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

//Iterative program to print diagonal view of tree
public class DiagonalViewOfTree {

    public void printDiagonalView(TreeNode root) {
        try {
            // check for null tree
            if (root == null)
                return;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                TreeNode temp = q.poll();
                if (temp == null) {
                    if (q.size() == 0) {
                        return;
                    }
                    System.out.println();
                    q.add(null);
                }
                else {
                    while (temp != null) {
                        System.out.print(temp.data);
                        if (temp.left != null) {
                            q.add(temp.left);
                        }
                        temp = temp.right;
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Exception in printing diagonal view of tree");
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        DiagonalViewOfTree obj = new DiagonalViewOfTree();
        obj.printDiagonalView(root);
    }
}
