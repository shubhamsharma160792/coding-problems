package com.java.tree.traversal;

public class RootToLeafPathSum {

    public int requiredSum = 137;

    private int globalSum   = 0;

    private void findLeafPathSum(int number, TreeNode root) {
        number = root.data + number * 10;
        if (root.left == null && root.right == null) {
            if (requiredSum == number)
                System.out.println("True");
        }
        if (root.left != null)
            findLeafPathSum(number, root.left);
        if (root.right != null)
            findLeafPathSum(number, root.right);
    }

    private int rootToLeafPathSumV2(TreeNode root, int number) {
        number = number * 10 + root.data;
        if (root.left == null && root.right == null) {
            this.globalSum += number;
        }
        if (root.left != null)
            rootToLeafPathSumV2(root.left, number);
        if (root.right != null)
            rootToLeafPathSumV2(root.right, number);
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
        RootToLeafPathSum obj = new RootToLeafPathSum();
        obj.findLeafPathSum(0, root);
        System.out.println(obj.rootToLeafPathSumV2(root, 0));
        // System.out.println("root to leaf path sum equal to given number " +
        // obj.rootToLeafPathSum(root));
    }

}
