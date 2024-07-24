class Pair {
    long node;
    long dist;
    Pair(long n, long d) {
        dist = d;
        node = n;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Long.compare(x.dist, y.dist));
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        long[] ways = new long[n];
        ways[0] = 1;
        distance[0] = 0;
        pq.add(new Pair(0, 0));
        long mod = 1000000007;
        while (!pq.isEmpty()) {
            long node = pq.peek().node;
            long dist = pq.peek().dist;
            pq.poll();
            for (Pair p : adj.get((int) node)) {
                long adjnode = p.node;
                long edgeW = p.dist;
                if (dist + edgeW < distance[(int) adjnode]) {
                    distance[(int) adjnode] = dist + edgeW;
                    ways[(int) adjnode] = ways[(int) node];
                    pq.add(new Pair(adjnode, dist + edgeW));
                } else if (dist + edgeW == distance[(int) adjnode]) {
                    ways[(int) adjnode] = (ways[(int) adjnode] + ways[(int) node]) % mod;
                }
            }
        }
        return (int) (ways[n - 1] % mod);
    }
}
