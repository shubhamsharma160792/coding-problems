package com.java.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    private Integer globalSum = 0;
    private Integer leafNodesCounter = 0;
    static class TreeNode {
        private int     data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            super();
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    private void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    private void levelOrderTraversal(TreeNode root) {
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

    private void preOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }
        }
    }

    private void postOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            s2.push(temp);
            if(temp.left!=null)
                s1.push(temp.left);
            if(temp.right != null)
                s1.push(temp.right);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    private void inOrderIterative(TreeNode root) {
        if (root == null)
            return;
        boolean allVisited = false;
        Stack<TreeNode> s = new Stack<>();
        TreeNode currentNode = root;
        while (!allVisited) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            }
            else {
                if (s.isEmpty()) {
                    allVisited = true;
                }
                else {
                    currentNode = s.pop();
                    System.out.print(currentNode.data + " ");
                    currentNode = currentNode.right;
                }
            }
        }
    }

    private int heightOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    private int rootToLeafPathSum(TreeNode root, int num) {
        num = root.data + num * 10;
        if (root.left == null && root.right == null) {
            this.globalSum += num;
        }
        if (root.left != null)
            rootToLeafPathSum(root.left, num);
        if (root.right != null)
            rootToLeafPathSum(root.right, num);
        return this.globalSum;
    }

    private int countOfLeafNodes(TreeNode root) {
        if (root.left == null && root.right == null) {
            this.leafNodesCounter++;
        }
        if (root.left != null)
            countOfLeafNodes(root.left);
        if (root.right != null)
            countOfLeafNodes(root.right);
        return this.leafNodesCounter;
    }

    private boolean findLeafPathSum(TreeNode root, int num, int requiredNum) {
        num = num * 10 + root.data;
        boolean found = false;
        if (root.left == null && root.right == null) {
            if (requiredNum == num) {
                found = true;
            }
        }
        if (root.left != null)
            findLeafPathSum(root.left, num, requiredNum);
        if (root.right != null)
            findLeafPathSum(root.right, num, requiredNum);
        return found;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Test obj = new Test();
        System.out.println("Pre Order: ");
        obj.preOrderTraversal(root);
        System.out.println();
        System.out.println("In Order: ");
        obj.inOrderTraversal(root);
        System.out.println();
        System.out.println("Post Order: ");
        obj.postOrderTraversal(root);
        System.out.println();
        System.out.println("Level Order: ");
        obj.levelOrderTraversal(root);
        System.out.println();
        System.out.println("Pre Order Iterative: ");
        obj.preOrderIterative(root);
        System.out.println();
        System.out.println("In Order Iterative: ");
        obj.inOrderIterative(root);
        System.out.println();
        System.out.println("Post Order Iterative: ");
        obj.postOrderIterative(root);
        System.out.println();
        System.out.printf("Height of Tree: %d", obj.heightOfTree(root));
        System.out.println();
        System.out.printf("Root to leaf path sum: %d", obj.rootToLeafPathSum(root, 0));
        System.out.println();
        System.out.printf("Leaf nodes count: %d", obj.countOfLeafNodes(root));
        System.out.println();
        System.out.printf("Root to leaf path sum found: %b", obj.findLeafPathSum(root, 0, 137));
    }
}
