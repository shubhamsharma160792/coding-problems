package com.java.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Revision {
    
    private int globalSum = 0;
    private int maxLevel  = 0;

    static class TreeNode{
        private int      data;
        private TreeNode left,right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private void printPreOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    private void printInOrder(TreeNode root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    private void printPostOrder(TreeNode root) {
        if (root == null)
            return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    private void printPreOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null)
                s.push(temp.right);
            if (temp.left != null)
                s.push(temp.left);
        }
    }

    private void printInOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        boolean allVisited = false;
        TreeNode current = root;
        while (!allVisited) {
            if (current != null) {
                s.push(current);
                current = current.left;
            }
            else {
                if (s.isEmpty()) {
                    allVisited = true;
                }
                else {
                    current = s.pop();
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    private void printPostOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            s2.push(temp);
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    private void printLevelOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
    }

    private int rootToLeafPathSum(TreeNode root, int sum) {
        sum = sum * 10 + root.data;
        if (root.left == null && root.right == null)
            this.globalSum += sum;
        if (root.left != null)
            rootToLeafPathSum(root.left, sum);
        if (root.right != null)
            rootToLeafPathSum(root.right, sum);
        return this.globalSum;
    }

    private boolean findLeafPathSum(TreeNode root, int num, int requiredNum) {
        num = num * 10 + root.data;
        boolean found = false;
        if (root.left == null && root.right == null) {
            if (requiredNum == num)
                found = true;
        }
        if (root.left != null)
            found = found || findLeafPathSum(root.left, num, requiredNum);
        if (root.right != null)
            found = found || findLeafPathSum(root.right, num, requiredNum);
        return found;
    }

    private int countOfLeafNodes(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return countOfLeafNodes(root.left) + countOfLeafNodes(root.right);
    }

    private void leftViewUtil(TreeNode root, int level) {
        if (root == null)
            return;
        if (level > this.maxLevel) {
            System.out.print(root.data + " ");
            this.maxLevel = level;
        }
        leftViewUtil(root.left, level + 1);
        leftViewUtil(root.right, level + 1);
    }

    private void leftViewOfTree(TreeNode root) {
        leftViewUtil(root, 1);
    }

    private void printRightView(TreeNode root){
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                TreeNode temp = q.poll();
                if (i == n)
                    System.out.print(temp.data + " ");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }


    public static void main(String[] args) {
        Revision obj = new Revision();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("Pre Order Traversal:");
        obj.printPreOrder(root);
        System.out.println();
        System.out.println("Pre Order Traversal Iterative:");
        obj.printPreOrderIterative(root);
        System.out.println();
        System.out.println("In Order Traversal:");
        obj.printInOrder(root);
        System.out.println();
        System.out.println("In Order Traversal Iterative:");
        obj.printInOrderIterative(root);
        System.out.println();
        System.out.println("Post Order Traversal:");
        obj.printPostOrder(root);
        System.out.println();
        System.out.println("Post Order Traversal Iterative:");
        obj.printPostOrderIterative(root);
        System.out.println();
        System.out.println("Level Order Traversal Iterative:");
        obj.printLevelOrderIterative(root);
        System.out.println();
        System.out.printf("Leaf nodes count %d", obj.countOfLeafNodes(root));
        System.out.println();
        System.out.printf("Root to leaf path sum %d", obj.rootToLeafPathSum(root, 0));
        System.out.println();
        System.out.printf("leaf Path found %b for number %d", obj.findLeafPathSum(root, 0, 125), 125);
        System.out.println();
        System.out.println("Left view of tree");
        obj.leftViewOfTree(root);
        System.out.println();
        System.out.println("Right view of tree");
        obj.printRightView(root);
    }
}
