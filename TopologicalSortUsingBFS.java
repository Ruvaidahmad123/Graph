class Solution
{
    //Function to return list containing vertices in Topological order. 
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Queue<Integer>q=new LinkedList<>();
        int indegree[]=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;            
            }
        }
        int topo[]=new int[V];       
        for(int i=0;i<V;i++){
            if(indegree[i]==0){     //add alll nodes with zero indegree because they are adjacent of noone means they will come first
                q.add(i);
            }
        }
        int i=0;
        while(!q.isEmpty()){     //first element of stack will always come first in array
            int node=q.poll();
            topo[i++]=node;
            for(int it:adj.get(node)){
                indegree[it]--;          //remove the link(edge) between that node and it node
                if(indegree[it]==0){
                    q.add(it);           //once indegree is zero add them to queue
                }
            }
        }
        return topo;
    }
}
