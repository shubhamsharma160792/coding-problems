package com.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {

    private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    private Boolean[]                   visitedVertex;

    public Graph(int numberOfVertex) {
        visitedVertex = new Boolean[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++) {
            adjacencyList.put(i, new ArrayList<Integer>());
            visitedVertex[i] = false;
        }
    }

    public void addEdge(int v1, int v2) {
        List<Integer> v1List = adjacencyList.get(v1);
        List<Integer> v2List = adjacencyList.get(v2);
        if (v1List != null && v1List != null) {
            v1List.add(v2);
            v2List.add(v1);
        }
    }

    public void removeEdge(int v1, int v2) {
        List<Integer> v1List = adjacencyList.get(v1);
        List<Integer> v2List = adjacencyList.get(v2);
        if (v1List != null && v1List != null) {
            v1List.remove(v2);
            v2List.remove(v1);
        }
    }

    public void addVertex(int v) {
        if (adjacencyList.get(v) == null) {
            adjacencyList.put(v, new ArrayList<Integer>());
        }
        else {
            System.out.println("Vertex already present in graph");
        }
    }

    public void removeVertex(int v) {
        List<Integer> vList = adjacencyList.get(v);
        if (vList == null) {
            System.out.println("No given vertex is present in graph");
            return;
        }
        for (List<Integer> list : adjacencyList.values()) {
            list.remove(v);
        }
        adjacencyList.remove(v);
    }

    public void bfs(int v) {
        visitedVertex[v] = true;
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(v);
        while(!q.isEmpty()){
            Integer node = (Integer) q.poll();
            System.out.println(node);
            for (int c : adjacencyList.get(node)) {
                if (!visitedVertex[c]) {
                    q.add(c);
                    visitedVertex[c] = true;
                }
            }
        }
    }

    public void dfs(int v) {
        System.out.println(v);
        visitedVertex[v] = true;
        for (Integer i : adjacencyList.get(v)) {
            if (!visitedVertex[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Graph obj = new Graph(6);
        obj.addEdge(0, 1);
        obj.addEdge(1, 2);
        obj.addEdge(2, 3);
        obj.addEdge(3, 4);
        obj.addEdge(2, 4);
        // obj.dfs(0);
        System.out.println("BFS:");
        obj.bfs(0);
        System.out.println("DFS:");
        obj.dfs(0);
    }
}
