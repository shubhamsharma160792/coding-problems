package com.java.tree.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversal {

    private List<List<Integer>> doTask(TreeNode root) {
        if (root == null)
            return null;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        q.add(root);
        int min = 0, max = 0;
        columnQueue.add(0);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = columnQueue.poll();
            map.putIfAbsent(col, new ArrayList<Integer>());
            map.get(col).add(node.data);
            if (node.left != null) {
                q.add(node.left);
                columnQueue.add(col - 1);
                min = Math.min(min, col - 1);
            }
            if (node.right != null) {
                q.add(node.right);
                columnQueue.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        for(int i=min;i <=max;i++){
            result.add(map.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        VerticalOrderTraversal obj = new VerticalOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = obj.doTask(root);
        for (List<Integer> val : result) {
            for (Integer i : val) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }



}
