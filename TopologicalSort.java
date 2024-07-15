//if there is an edge from u to v then u should come before v in topological sorted array so thats why we used stack we went deep and deep using DFS and last one will be inserted fast and first one inserted last
class Solution
{
    //Function to return list containing vertices in Topological order. 
    public static void DFS(int node,ArrayList<ArrayList<Integer>> adj,boolean visited[],Stack<Integer>st){
        visited[node]=true;
        for(Integer i:adj.get(node)){
            if(visited[i]==false){
                DFS(i,adj,visited,st);
            }
        }
        st.push(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean visited[]=new boolean[V];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                DFS(i,adj,visited,st);
            }
        }
        int ans[]=new int[V];
        int i=0;
        while(!st.isEmpty()){
            ans[i++]=st.pop();
        }
        return ans;
    }
}
