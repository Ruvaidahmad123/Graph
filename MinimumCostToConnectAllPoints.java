class Pair {
    int node;
    int weight;
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public ArrayList<ArrayList<Pair>> createAdj(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new Pair(j, dist));
            }
        }
        return adj;
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<Pair>> adj = createAdj(points);
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Pair(0, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.weight;

            if (visited[node]) continue;
            visited[node] = true;
            sum += wt;

            for (Pair neighbor : adj.get(node)) {
                if (!visited[neighbor.node]) {
                    pq.add(new Pair(neighbor.node, neighbor.weight));
                }
            }
        }

        return sum;
    }
}
//optimized
class Pair {
    int node;
    int weight;
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int minNode = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (minNode == -1 || minDist[j] < minDist[minNode])) {
                    minNode = j;
                }
            }

            visited[minNode] = true;
            sum += minDist[minNode];

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(points[minNode][0] - points[j][0]) + Math.abs(points[minNode][1] - points[j][1]);
                    if (dist < minDist[j]) {
                        minDist[j] = dist;
                    }
                }
            }
        }

        return sum;
    }
}
