// You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
// Note: Use the recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.


// Example 1:

// Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]

// Output: 0 2 4 3 1
// Explanation: 
// 0 is connected to 2, 3, 1.
// 1 is connected to 0.
// 2 is connected to 0 and 4.
// 3 is connected to 0.
// 4 is connected to 2.
// so starting from 0, it will go to 2 then 4,
// and then 3 and 1.
// Thus dfs will be 0 2 4 3 1.
class Solution {
    // Function to return a list containing the DFS traversal of the graph4
    public void DFS(int node,ArrayList<ArrayList<Integer>> adj,boolean visited[],ArrayList<Integer>dfs){
        dfs.add(node);
        visited[node]=true;
        for(Integer i:adj.get(node)){
            if(visited[i]==false){
                DFS(i,adj,visited,dfs);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer>dfs=new ArrayList<Integer>();
        boolean visited[]=new boolean[V];
        visited[0]=true;
        DFS(0,adj,visited,dfs);
        return dfs;
    }
}
