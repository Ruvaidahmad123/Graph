class Pair {
    int node;
    int dist;
    Pair(int n, int d) {
        node = n;
        dist = d;
    }
}

class Ruvaid {
    int stop;
    int node;
    int dist;
    Ruvaid(int s, int n, int d) {
        stop = s;
        node = n;
        dist = d;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Correctly populate the adjacency list
        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = (int) 1e9;
        }
        distance[src] = 0;

        Queue<Ruvaid> q = new LinkedList<>();
        q.add(new Ruvaid(0, src, 0));

        while (!q.isEmpty()) {
            Ruvaid current = q.poll();
            int stop = current.stop;
            int node = current.node;
            int dist = current.dist;

            if (stop > k) {
                continue;
            }

            for (Pair it : adj.get(node)) {
                int adjnode = it.node;
                int cost = it.dist;

                if (dist + cost < distance[adjnode] && stop <= k) {
                    distance[adjnode] = dist + cost;
                    q.add(new Ruvaid(stop + 1, adjnode, distance[adjnode]));
                }
            }
        }

        if (distance[dst] == (int) 1e9) {
            return -1;
        }
        return distance[dst];
    }
}
