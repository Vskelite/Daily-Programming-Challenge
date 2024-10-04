// Problem : Detect a Cycle in an Undirected Graph
// You are given an undirected graph represented by an adjacency list. Your task is to determine if the graph contains any cycle. A cycle is formed if you can traverse through a sequence of edges that starts and ends at the same vertex.

// Input : V = 5, E = 5
// Edges = [[0, 1], [1, 2], [2, 3], [3, 4], [4, 0]]

// Output : true

import java.util.ArrayList;
import java.util.List;

public class Day26 {

    
    public static boolean containsCycle(int V, int[][] edges) {
       
        List<List<Integer>> graph = new ArrayList<>();
        
        
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) { 
                if (dfs(i, -1, visited, graph)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
            
                if (dfs(neighbor, node, visited, graph)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
       
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};
        System.out.println(containsCycle(V, edges)); 

    }
}

