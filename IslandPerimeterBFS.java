class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        int starti=-1;
        int startj=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    starti=i;
                    startj=j;
                    break;
                }
            }
        }
        if(starti==-1 && startj==-1)return 0;
        int perimeter=0;
        Queue<Pair>pq=new LinkedList<>();
        pq.add(new Pair(starti,startj));
        int delrow[]={-1,0,1,0};
        int delcol[]={0,-1,0,1};
        visited[starti][startj]=true;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int row=p.i;
            int col=p.j;
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if (nrow < 0 || nrow >= m || ncol < 0 || ncol >= n || grid[nrow][ncol] == 0) {
                    perimeter++;
                } 
                else if (!visited[nrow][ncol] && grid[nrow][ncol] == 1) {
                    visited[nrow][ncol] = true;
                    pq.add(new Pair(nrow, ncol));
                }
            }
        }
        return perimeter;
    }
}
