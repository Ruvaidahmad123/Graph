class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int minCycle = Integer.MAX_VALUE; 
        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, -1); 
            Queue<Integer> q = new LinkedList<>();
            q.offer(i); 
            dist[i] = 0; 
            while (!q.isEmpty()) {
                int u = q.poll(); 
                for (int v : adj[u]) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        q.offer(v);
                    }
                    // or if the current node is visited and its not equal to curr_index and the
                    // dist[u] (curr_node) is greater or equal to dist[u] (prev_node) + 1
                    // it neans we have found our cycle and store the value in minCycle
                    else if (v != i && dist[v] >= dist[u]) {
                        minCycle = Math.min(minCycle, dist[u] + dist[v] + 1);
                    }
                }
            }

        }
        if (minCycle == Integer.MAX_VALUE)
            return -1;
        return minCycle;
    }
}
