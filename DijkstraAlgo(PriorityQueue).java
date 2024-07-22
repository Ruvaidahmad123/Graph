class Pair{
    int distance;
    int node;
    Pair(int d,int n){
        distance=d;
        node=n;
    }
}
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair>pq=new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
        int distance[]=new int[V];
        for(int i=0;i<V;i++){
            distance[i]=(int)1e9;
        }
        distance[S]=0;
        pq.add(new Pair(0,S));
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int dist=pq.peek().distance;
            pq.remove();
            for(int i=0;i<adj.get(node).size();i++){
                int adjNode=adj.get(node).get(i).get(0);
                int edgeWeight=adj.get(node).get(i).get(1);
                if(dist+edgeWeight<distance[adjNode]){
                    distance[adjNode]=dist+edgeWeight;
                    pq.add(new Pair(distance[adjNode],adjNode));
                }
            }
        }
        return distance;
    }
}
