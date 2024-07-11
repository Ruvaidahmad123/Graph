// Given an undirected graph with V nodes and E edges, create and return an adjacency list of the graph. 0-based indexing is followed everywhere.
// Example 1:
// Input:
// V = 5, E = 7
// edges = {(0,1),(0,4),(4,1),(4,3),(1,3),(1,2),(3,2)}
// Output: 
// {{1,4}, 
//  {0,2,3,4}, 
//  {1,3},
//  {1,2,4},
//  {0,1,3}}
// Explanation:
// Node 0 is connected to 1 and 4.
// Node 1 is connected to 0,2,3 and 4.
// Node 2 is connected to 1 and 3.
// Node 3 is connected to 1,2 and 4.
// Node 4 is connected to 0,1 and 3.
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            ans.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            ans.get(edges[i][0]).add(edges[i][1]);
            ans.get(edges[i][1]).add(edges[i][0]);
        }
        return ans;
    }
}
