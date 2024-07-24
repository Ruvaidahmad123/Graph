class Pair {
    int node;
    int dist;
    Pair(int n, int d) {
        node = n;
        dist = d;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int) 1e9);
        distance[k] = 0;

        for (int[] time : times) {
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Pair(k, 0));

        int res = 0;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int dist = current.dist;
            if (dist > distance[node]) continue;
            res = Math.max(res, dist);
            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                int edgeWeight = neighbor.dist;
                if (distance[node] + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = distance[node] + edgeWeight;
                    pq.add(new Pair(adjNode, distance[adjNode]));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (distance[i] == (int) 1e9) {
                return -1;
            }
        }
        return res;
    }
}
