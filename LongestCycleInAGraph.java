class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] indegree = new int[n];
        for (int node = 0; node < n; node++) {
            if (edges[node] != -1) {
                indegree[edges[node]]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        boolean[] visited = new boolean[n];

        // Perform topological sorting to eliminate non-cyclic nodes
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            if (edges[node] != -1) {
                indegree[edges[node]]--;
                if (indegree[edges[node]] == 0) {
                    queue.offer(edges[node]);
                }
            }
        }

        // Find the longest cycle in the remaining graph
        int maxCycleLength = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int length = 0;
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    length++;
                    current = edges[current];
                }
                maxCycleLength = Math.max(maxCycleLength, length);
            }
        }

        return maxCycleLength;
    }
}
