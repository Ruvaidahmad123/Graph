class Solution {
    public ArrayList<ArrayList<Integer>> adjacancyList(int V, int edges[][]) {
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            ans.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            ans.get(edges[i][0]).add(edges[i][1]);
            ans.get(edges[i][1]).add(edges[i][0]);
        }
        return ans;
    }
    public int DFS(int node, ArrayList<ArrayList<Integer>> adj, boolean visited[], List<Boolean> hasApple) {
        visited[node] = true;
        int totalTime = 0;
        for (Integer i : adj.get(node)) {
            if (!visited[i]) {
                int timeSpent = DFS(i, adj, visited, hasApple);
                if (timeSpent > 0 || hasApple.get(i)) {
                    totalTime += timeSpent + 2;    //if no apple at leaf node then it return 0 automatically
                }
            }
        }
        return totalTime;
    }
    public int minTime(int V, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>>adj=adjacancyList(V,edges);
        ArrayList<Integer>dfs=new ArrayList<Integer>();
        boolean visited[]=new boolean[V];
        visited[0]=true;
        return DFS(0,adj,visited,hasApple);
    }
}
