// Leetcode 1192
class Solution {
    private int timer = 1;

    private void dfs(int node, int parent, int[] vis,
                     ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low,
                     List<List<Integer>> bridges) {
        // Mark the current node as visited
        vis[node] = 1;
        // Initialize discovery time and low value
        tin[node] = low[node] = timer;
        timer++;

        // Traverse all adjacent nodes
        for (Integer it : adj.get(node)) {
            if (it == parent) continue; // Skip the parent node

            if (vis[it] == 0) {
                // If 'it' is not visited, recurse with DFS
                dfs(it, node, vis, adj, tin, low, bridges);

                // Update the low value of the current node
                low[node] = Math.min(low[node], low[it]);

                // If the condition for a bridge is satisfied, add it to the result list
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(it, node));
                }
            } else {
                // Update the low value if 'it' is already visited and not the parent
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list with given connections
        for (List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Initialize arrays to keep track of visited nodes, discovery times, and low values
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        // Perform DFS from the first node
        dfs(0, -1, vis, adj, tin, low, bridges);

        return bridges;
    }
}
