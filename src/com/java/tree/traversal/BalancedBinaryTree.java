package com.java.tree.traversal;

public class BalancedBinaryTree {

    private int height(TreeNode A) {
        if (A == null)
            return 0;
        return 1 + Math.max(height(A.left), height(A.right));
    }

    private boolean isBalanced(TreeNode A) {
        if (A == null)
            return true;
        int leftHeight = height(A.left);
        int rightHeight = height(A.right);
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            if (isBalanced(A.left) && isBalanced(A.right))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BalancedBinaryTree obj = new BalancedBinaryTree();
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(4);
        A.left.right.right = new TreeNode(4);
        A.left.right.right = new TreeNode(4);

        boolean isBalanced = obj.isBalanced(A);
        if (isBalanced)
            System.out.println("Binary Tree balanced");
        else
            System.out.println("Binary Tree not balanced");
    }

}
