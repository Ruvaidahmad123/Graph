//if there's a cycle its not possible to finish all courses
class Solution {
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
            if(indegree[i]==0){        
                q.add(i);
            }
        }
        while(!q.isEmpty()){    
            int node=q.poll();
            count++;
            for(int it:adj.get(node)){
                indegree[it]--;       
                if(indegree[it]==0){
                    q.add(it);           
                }
            }
        }
        return !(count==V);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean flag= isCyclic(numCourses,adj);
        if(flag==true){
            return false;
        }
        return true;
    }
}
