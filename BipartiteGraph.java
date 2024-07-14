// graph which can be coloured in such a way that 2 adjacent nodes don't have same colors.
// any graph which is linear is always biparite
// graph having cycle with even nodes is bipartite as well
//BFS
lass Solution {
    public boolean check(int vrtx,int n,int[][] graph,int[] color){
        color[vrtx]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(vrtx);
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int adj:graph[node]){
                if(color[adj]==-1){
                    color[adj]=1-color[node];
                    q.add(adj);
                }
                else if(color[adj]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        for(int i=0;i<color.length;i++){
            color[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(check(i,n,graph,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
}
//DFS
class Solution
{
    private boolean dfs(int node, int col, int color[], 
    ArrayList<ArrayList<Integer>>adj) {
        
        color[node] = col; 
        
        // traverse adjacent nodes
        for(int it : adj.get(node)) {
            // if uncoloured
            if(color[it] == -1) {
                if(dfs(it, 1 - col, color, adj) == false) return false; 
            }
            // if previously coloured and have the same colour
            else if(color[it] == col) {
                return false; 
            }
        }
        
        return true; 
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V];
	    for(int i = 0;i<V;i++) color[i] = -1; 
	    
	    // for connected components
	    for(int i = 0;i<V;i++) {
	        if(color[i] == -1) {
	            if(dfs(i, 0, color, adj) == false) return false; 
	        }
	    }
	    return true; 
    }
