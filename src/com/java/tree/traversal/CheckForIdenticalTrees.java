package com.java.tree.traversal;

public class CheckForIdenticalTrees {

    private boolean doTask(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return true;
        if (A.data != B.data)
            return false;
        if ((A.left != null && B.left == null) || (A.left == null && B.left != null))
            return false;
        if ((A.right != null && B.right == null) || (A.right == null && B.right != null))
            return false;
        return doTask(A.left, B.left) && doTask(A.right, B.right);
    }

    public static void main(String[] args) {
        CheckForIdenticalTrees obj = new CheckForIdenticalTrees();
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(4);

        TreeNode B = new TreeNode(1);
        B.left = new TreeNode(2);
        B.right = new TreeNode(3);
        B.left.left = new TreeNode(4);
        B.left.right = new TreeNode(5);

        System.out.printf("Trees are identical %b", obj.doTask(A, B));
    }

}
