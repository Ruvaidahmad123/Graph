//sum of weight in minimum spanning tree
class Pair {
    int node;
    int weight;
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Pair(0, 0));
        int sum = 0;
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int wt = pq.peek().weight;
            pq.remove();
            if (visited[node]==true) continue;
            visited[node] = true;
            sum += wt;
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];
                if (!visited[adjNode]) {
                    pq.add(new Pair(adjNode, edgeWeight));
                }
            }
        }
        return sum;
    }
}
//to get minimum spanning tree
import java.util.*;

class Pair {
    int node;
    int weight;
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Edge {
    int src;
    int dest;
    int weight;
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj, List<Edge> mstEdges) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Pair(0, 0));
        int sum = 0;
        
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int wt = pq.peek().weight;
            pq.remove();
            
            if (visited[node]) continue;
            visited[node] = true;
            sum += wt;
            
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];
                if (!visited[adjNode]) {
                    pq.add(new Pair(adjNode, edgeWeight));
                    mstEdges.add(new Edge(node, adjNode, edgeWeight));
                }
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int V = 5; // number of vertices
        int E = 7; // number of edges
        List<List<int[]>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Example edges (src, dest, weight)
        adj.get(0).add(new int[]{1, 2});
        adj.get(0).add(new int[]{3, 6});
        adj.get(1).add(new int[]{0, 2});
        adj.get(1).add(new int[]{2, 3});
        adj.get(1).add(new int[]{3, 8});
        adj.get(1).add(new int[]{4, 5});
        adj.get(2).add(new int[]{1, 3});
        adj.get(2).add(new int[]{4, 7});
        adj.get(3).add(new int[]{0, 6});
        adj.get(3).add(new int[]{1, 8});
        adj.get(4).add(new int[]{1, 5});
        adj.get(4).add(new int[]{2, 7});
        
        List<Edge> mstEdges = new ArrayList<>();
        int totalWeight = spanningTree(V, E, adj, mstEdges);
        
        System.out.println("Total weight of MST: " + totalWeight);
        System.out.println("Edges in the MST:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}
