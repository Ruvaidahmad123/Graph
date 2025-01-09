class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        int max=0;
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    q.add(new Pair(i,j));
                    visited[i][j]=true;
                    int cnt=0;
                    while(!q.isEmpty()){
                        cnt++;
                        Pair p=q.poll();
                        int row=p.i;
                        int col=p.j;
                        int delrow[]={-1,0,1,0};
                        int delcol[]={0,-1,0,1};
                        for(int k=0;k<4;k++){
                            int nrow=row+delrow[k];
                            int ncol=col+delcol[k];
                            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol]==false && grid[nrow][ncol]==1){
                                visited[nrow][ncol]=true;
                                q.add(new Pair(nrow,ncol));
                            }
                        }

                    }
                    max=Math.max(max,cnt);
                }
            }
        }
        return max;
    }
}
