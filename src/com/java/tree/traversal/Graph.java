package com.java.tree.traversal;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<List<Integer>> nodeList;

    public Graph(int n) {
        this.nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeList.add(new ArrayList<>());
        }
    }


}
