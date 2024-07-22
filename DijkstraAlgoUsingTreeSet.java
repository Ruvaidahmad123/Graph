import java.util.*;

class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Create a TreeSet for storing the nodes as a pair {dist,node}
        // where dist is the distance from source to the node.
        // TreeSet stores the nodes in ascending order of the distances.
        TreeSet<Pair> st = new TreeSet<>();

        // Initialising dist list with a large number to
        // indicate the nodes are unvisited initially.
        // This list contains distance from source to the nodes.
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        st.add(new Pair(0, S));

        // Source initialised with dist=0
        dist[S] = 0;

        // Now, erase the minimum distance node first from the set
        // and traverse for all its adjacent nodes.
        while (!st.isEmpty()) {
            Pair it = st.pollFirst(); 
            int node = it.node;
            int dis = it.dist;

            // Check for all adjacent nodes of the erased
            // element whether the prev dist is larger than current or not.
            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0);
                int edgW = neighbor.get(1);

                if (dis + edgW < dist[adjNode]) {
                    // erase if it was visited previously at 
                    // a greater cost.
                    if (dist[adjNode] != Integer.MAX_VALUE) {
                        st.remove(new Pair(dist[adjNode], adjNode));
                    }

                    // If current distance is smaller,
                    // push it into the queue
                    dist[adjNode] = dis + edgW;
                    st.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        // Return the array containing shortest distances
        // from source to all the nodes.
        return dist;
    }

    class Pair {
        int dist;
        int node;

        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
