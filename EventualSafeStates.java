//if a path from one node leads to a terminal node then its a safe node 
//if a node leads to a cycle then its not a safe node
class Solution {
     private boolean dfsCheck(int node, int [][]adj, int vis[], int pathVis[],int check[]) {
        vis[node] = 1; 
        pathVis[node] = 1; 
        for(int it : adj[node]) {
            if(vis[it] == 0) {
                if(dfsCheck(it, adj, vis, pathVis,check) == true) 
                    return true; 
            }
            else if(pathVis[it] == 1) {    
                return true; 
            }
        }
        check[node]=1;
        pathVis[node] = 0; 
        return false; 
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[]=new int[V];
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                dfsCheck(i, graph, vis, pathVis,check); 
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
}
