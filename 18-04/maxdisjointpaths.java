/*
There is a network of servers, given in the form of a directed graph and data is constantly being transfered among these servers. You can send the data from a given source server 's' to a destination server 't'. The data has to be tranfered along the disjoint paths. Find the maximum number of disjoint paths through which the data can be transfered.
 
Note:Two paths are said to be disjoint paths, if they don’t share any edge.

 Example:
 input =8
0 1 1 1 0 0 0 0
0 0 1 0 0 0 0 0
0 0 0 1 0 0 1 0
0 0 0 0 0 0 1 0
0 0 1 0 0 0 0 1
0 1 0 0 1 0 0 1
0 0 0 0 0 1 0 1
0 0 0 0 0 0 0 0
0 7

output = 2

 */

 import java.util.*;

public class Test {
    
    static int V;
    static int[][] graph;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int source = sc.nextInt();
        int dest = sc.nextInt();
        int maxPaths = maxDisjointPaths(source, dest);
        System.out.println(maxPaths);
    }
    
    static int maxDisjointPaths(int source, int dest) {
        int[][] residualGraph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                residualGraph[i][j] = graph[i][j];
            }
        }
        int[] parent = new int[V];
        int maxPaths = 0;
        while (bfs(residualGraph, source, dest, parent)) {
            maxPaths++;
            for (int v = dest; v != source; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] = 0;
                residualGraph[v][u] = 1;
            }
        }
        return maxPaths;
    }
    
    static boolean bfs(int[][] residualGraph, int source, int dest, int[] parent) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < V; v++) {
                if (!visited[v] && residualGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return visited[dest];
    }
}
 