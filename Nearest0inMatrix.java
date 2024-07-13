class Solution {
    class Pair{
    int row;
    int col;
    int dist;
    Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
    public int[][] updateMatrix(int[][] mat) {
        int ans[][]=mat;
        int n=mat.length;
        int m=mat[0].length;
        Queue<Pair>q=new LinkedList<>();
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    visited[i][j]=true;
                    q.add(new Pair(i,j,0));
                }
                else{
                    visited[i][j]=false;
                }
            }
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!q.isEmpty()){
            int rw=q.peek().row;
            int cl=q.peek().col;
            int steps=q.peek().dist;
            q.poll();
            ans[rw][cl]=steps;
            for(int i=0;i<4;i++){
                int nrow=rw+delrow[i];
                int ncol=cl+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==false && ans[nrow][ncol]!=0){
                    visited[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return ans;
    }
}
