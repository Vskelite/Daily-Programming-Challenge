import java.util.*;

public class Day27 {
    
    public static int shortestPathLength(int V, List<List<Integer>> edges, int start, int end) {
        
        List<List<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0)); 
        }

        if (start == end) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>(); 
        boolean[] visited = new boolean[V];
        queue.add(new int[]{start, 0}); 
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            for (int neighbor : graph.get(currentNode)) {
                if (!visited[neighbor]) {
                    if (neighbor == end) { 
                        return currentDistance + 1; 
                    }
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, currentDistance + 1}); 
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
       
        List<List<Integer>> edges1 = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(0, 2),
            Arrays.asList(1, 3),
            Arrays.asList(2, 3),
            Arrays.asList(3, 4)
        );
        System.out.println(shortestPathLength(5, edges1, 0, 4)); 
        
    }
}
