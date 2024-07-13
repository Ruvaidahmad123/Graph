class Pair{
    int first;
    int second;
    Pair(int fir,int sec){
        this.first=fir;
        this.second=sec;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph\
    public boolean checkBFS(int src,ArrayList<ArrayList<Integer>> adj,boolean visited[]){
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(src,-1));
        visited[src]=true;
        while(!q.isEmpty()){
            int node=q.peek().first;
            int parentnode=q.peek().second;
            q.poll();
            for(int adjacentnode:adj.get(node)){
                if(visited[adjacentnode]==false){
                    visited[adjacentnode]=true;
                    q.add(new Pair(adjacentnode,node));
                }
                else{
                    if(adjacentnode!=parentnode){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(checkBFS(i,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
