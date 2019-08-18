package com.java.tree.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrderTraversal {

    private List<List<Integer>> doTask(TreeNode root) {
        if (root == null)
            return null;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        q.add(root);
        int index = 0;
        boolean reverse = false;
        while (!q.isEmpty()) {
            int size = q.size();
            map.putIfAbsent(index, new ArrayList<Integer>());
            while (size > 0) {
                TreeNode node = q.poll();
                if(reverse)
                    s.push(node);
                else
                    map.get(index).add(node.data);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                size--;
            }
            if (reverse) {
                while (!s.isEmpty())
                    map.get(index).add(s.pop().data);
            }
            reverse = !reverse;
            index++;
        }
        for (int i = 0; i < index; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        ZigZagLevelOrderTraversal obj = new ZigZagLevelOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        List<List<Integer>> result = obj.doTask(root);
        for (List<Integer> val : result) {
            for (Integer i : val) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
