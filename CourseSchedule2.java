class Solution {
    public int[] isCyclic(int V,ArrayList<ArrayList<Integer>>adj){
        int indegree[]=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        int topo[]=new int[V];
        Queue<Integer>q=new LinkedList<Integer>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            topo[i++]=node;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(i==V){
            return topo;
        }
        else{
            return new int[0];
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int topo[]= isCyclic(numCourses,adj);
        return topo;
    }
}
