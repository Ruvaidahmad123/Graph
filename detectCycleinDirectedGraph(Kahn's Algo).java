class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer>q=new LinkedList<>();
        int indegree[]=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;            
            }
        }
        int count=0;
        for(int i=0;i<V;i++){
            if(indegree[i]==0){        //add alll nodes with zero indegree because they are adjacent of noone means they will come first
                q.add(i);
            }
        }
        while(!q.isEmpty()){     //first element of stack will always come first in array
            int node=q.poll();
            count++;
            for(int it:adj.get(node)){
                indegree[it]--;          //remove the link(edge) between that node and it node
                if(indegree[it]==0){
                    q.add(it);           //once indegree is zero add them to queue
                }
            }
        }
        return !(count==V);
    }
}
