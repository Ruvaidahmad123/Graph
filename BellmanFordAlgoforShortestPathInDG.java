//used to find shortest path from source node to all nodes
//give relaxation for n-1 times
//if still there is relaxation possible this means there is negative cycle i.e pathsum=-ve.
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int distance[]=new int[V];
        Arrays.fill(distance,(int)1e8);
        distance[S]=0;
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer>it:edges){
                int node=it.get(0);
                int adjnode=it.get(1);
                int wt=it.get(2);
                if(distance[node]!=(int)1e8 && distance[node]+wt<distance[adjnode]){
                    distance[adjnode]=distance[node]+wt;
                }
            }
        }
        //nth relaxation to check negative cycle
         for(ArrayList<Integer>it:edges){
                int node=it.get(0);
                int adjnode=it.get(1);
                int wt=it.get(2);
                if(distance[node]!=(int)1e8 && distance[node]+wt<distance[adjnode]){
                    int temp[]=new int[1];
                    temp[0]=-1;
                    return temp;
                }
        }
        return  distance;
        
    }
}
