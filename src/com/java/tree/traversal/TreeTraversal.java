package com.java.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

    private int globalSum = 0;

    static class TreeNode {
        private int      data;
        private TreeNode left, right;

        public TreeNode(int data) {
            super();
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    private void printPreOrderRecursive(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data);
        printPreOrderRecursive(root.left);
        printPreOrderRecursive(root.right);
    }

    private void printInOrderRecursive(TreeNode root) {
        if (root == null)
            return;
        printInOrderRecursive(root.left);
        System.out.print(root.data);
        printInOrderRecursive(root.right);
    }

    private void printPostOrderRecursive(TreeNode root) {
        if (root == null)
            return;
        printPostOrderRecursive(root.left);
        printPostOrderRecursive(root.right);
        System.out.print(root.data);
    }

    private void printPreOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            System.out.print(temp.data);
            if(temp.right != null)
                s.push(temp.right);
            if (temp.left != null)
                s.push(temp.left);
        }
    }

    private void printInOrderIterative(TreeNode root) {
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
                    System.out.print(currentNode.data);
                    currentNode = currentNode.right;
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
        while (!s2.isEmpty())
            System.out.print(s2.pop().data);
    }

    private int heightOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    private Integer countOfLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countOfLeafNodes(root.left) + countOfLeafNodes(root.right);
    }

    private void printLevelOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.data);
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
    }

    private int rootToLeafPathSum(int number, TreeNode root) {
        number = root.data + number * 10;
        if (root.left == null && root.right == null) {
            this.globalSum += number;
        }
        if (root.left != null) {
            rootToLeafPathSum(number, root.left);
        }
        if (root.right != null) {
            rootToLeafPathSum(number, root.right);
        }
        return this.globalSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeTraversal obj = new TreeTraversal();
        System.out.println("Pre order traversal recursive:");
        obj.printPreOrderRecursive(root);
        System.out.println();
        System.out.println("In order traversal recursive:");
        obj.printInOrderRecursive(root);
        System.out.println();
        System.out.println("Post order traversal recursive:");
        obj.printPostOrderRecursive(root);
        System.out.println();
        System.out.println("Pre order traversal iterative:");
        obj.printPreOrderIterative(root);
        System.out.println();
        System.out.println("In order traversal iterative:");
        obj.printInOrderIterative(root);
        System.out.println();
        System.out.println("Post order traversal iterative:");
        obj.printPostOrderIterative(root);
        System.out.println();
        System.out.println("Height of tree: " + obj.heightOfTree(root));
        System.out.println("Level order traversal recursive:");
        obj.printLevelOrderTraversal(root);
        System.out.println();
        System.out.printf("Root to leafs Path sum: %d", obj.rootToLeafPathSum(0, root));
        System.out.println();
        System.out.printf("Count of leaf nodes: %d", obj.countOfLeafNodes(root));
    }

}
