package com.java.tree.basic;

import com.java.tree.traversal.TreeNode;

public class MaxValueInTree {
    
    public Integer findMaxValue(TreeNode node) {
        int maxValue = Integer.MIN_VALUE;
        if (node != null) {
            int leftMax = findMaxValue(node.left);
            int rightMax = findMaxValue(node.right);
            if (leftMax > rightMax)
                maxValue = leftMax;
            else
                maxValue = rightMax;
            if (node.data > maxValue)
                maxValue = node.data;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        MaxValueInTree obj = new MaxValueInTree();
        Integer maxValue = obj.findMaxValue(root);
        System.out.println("maxValue: " + maxValue);
    }

}
