class Solution {
    public void BFS(int[][] isConnected,Queue<Integer>q,int vertex,boolean visited[]){
        q.add(vertex);
        visited[vertex]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i=0;i<isConnected[node-1].length;i++){
                if(isConnected[node-1][i]==1)
                if(visited[i+1]==false){
                    visited[i+1]=true;
                    q.add(i+1);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        int count=0;
        boolean visited[]=new boolean[V+1];
        Queue<Integer>q=new LinkedList<>();
        for(int i=1;i<=V;i++){
            if(visited[i]==false){
                BFS(isConnected,q,i,visited);
                count++;
            }
        }
        return count;
    }
}
