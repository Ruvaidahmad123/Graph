// Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
// Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the input graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.


// Example 1:

// Input:
// V = 5, E = 4
// adj = {{1,2,3},{},{4},{},{}}


// Output: 
// 0 1 2 3 4
// Explanation: 
// 0 is connected to 1 , 2 , 3.
// 2 is connected to 4.
// so starting from 0, it will go to 1 then 2
// then 3. After this 2 to 4, thus bfs will be
// 0 1 2 3 4.
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer>q=new LinkedList<>();
        ArrayList<Integer>bfs=new ArrayList<Integer>();
        boolean visited[]=new boolean[V];
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            bfs.add(node);
            for(Integer it:adj.get(node)){
                if(visited[it]==false){
                    visited[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}
