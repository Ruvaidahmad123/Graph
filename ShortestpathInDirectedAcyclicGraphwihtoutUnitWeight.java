class Pair{
    int first;
    int weight;
    Pair(int fir,int w){
        this.first=fir;
        this.weight=w;
    }
}
class Solution {
    public void toposort(int node, ArrayList < ArrayList < Pair >> adj,
    int visited[], Stack < Integer > st){
        visited[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            int v=adj.get(node).get(i).first;
            if (visited[v] == 0){
                toposort(v, adj, visited, st);
            }
        }
        st.add(node);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
		for(int i=0;i<N;i++){
		    adj.add(new ArrayList<Pair>());
		}
		for(int i=0;i<M;i++){
		    int node=edges[i][0];
		    int nextadj=edges[i][1];
		    int wt=edges[i][2];
		    adj.get(node).add(new Pair(nextadj,wt));
		}
		int visited[]=new int[N];
		Stack<Integer>st=new Stack<>();
		for(int i=0;i<N;i++){
		    if(visited[i]==0)
		    toposort(i,adj,visited,st);
		}
		int dist[] = new int[N];
        for (int i = 0; i < N; i++) {
          dist[i] = (int)(1e9);
        }
        dist[0] = 0;
        while (!st.isEmpty()) {
          int node = st.peek();
          st.pop();
          for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;
            int wt = adj.get(node).get(i).weight;
    
            if (dist[node] + wt < dist[v]) {
              dist[v] = wt + dist[node];
            }
          }
        }
        for (int i = 0; i < N; i++) {
          if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
	}
}
