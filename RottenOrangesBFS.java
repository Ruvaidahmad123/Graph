class Pair{
    int row;
    int col;
    int tm;
    Pair(int row,int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair>q=new LinkedList<Pair>();
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        int cntfresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                else{
                    visited[i][j]=0;
                }
                if(grid[i][j]==1){
                    cntfresh++;
                }
            }
        }
        int time=0;
        int count=0;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!q.isEmpty()){
            int rw=q.peek().row;
            int cl=q.peek().col;
            int t=q.peek().tm;
            time=Math.max(time,t);
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=rw+delrow[i];
                int ncol=cl+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    count++;
                    q.add(new Pair(nrow,ncol,t+1));
                    visited[nrow][ncol]=2;
                }
            }
        }
        if(count!=cntfresh){
            return -1;
        }
        return time;
    }
}
