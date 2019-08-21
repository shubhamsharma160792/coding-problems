package com.java.tree.traversal;

public class SymmetricBinaryTree {

    private int isSymmetricUtil(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return 1;
        if (A.data != B.data)
            return 0;
        if ((A.left != null && B.right == null) || (A.left == null && B.right != null))
            return 0;
        if ((A.right != null && B.left == null) || (A.right == null && B.left != null))
            return 0;
        return isSymmetricUtil(A.left, B.right) & isSymmetricUtil(A.right, B.left);
    }

    public int isSymmetric(TreeNode A) {
        return isSymmetricUtil(A, A);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(2);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(5);
        A.right.right = new TreeNode(4);
        SymmetricBinaryTree obj = new SymmetricBinaryTree();
        System.out.printf("Symmetric binary Tree: %d", obj.isSymmetric(A));
    }

}
