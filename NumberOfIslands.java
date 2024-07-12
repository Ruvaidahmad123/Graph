class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public void bfs(int r,int c,char[][] grid,int[][] vis,int n,int m){
        vis[r][c] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(r,c));

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
                for(int nRows=-1;nRows<=1;nRows++){        //for going vertically and horizontally of row
                    for(int nCols=-1;nCols<=1;nCols++){
                        int nRow = row+nRows;
                        int nCol = col+nCols;
                       
                        if((nRows == 0 || nCols == 0) && nRow >= 0 && nRow<n && nCol>=0 && nCol <m 
                        && grid[nRow][nCol] == '1' && vis[nRow][nCol] == 0){
                            vis[nRow][nCol] = 1;
                            q.offer(new Pair(nRow,nCol));
                        }
                    }
                }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis= new int[n][m];
        int count = 0;

        for(int row = 0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col] == '1' &&vis[row][col] == 0){
                    bfs(row,col,grid,vis,n,m);
                    count++;
                }
            }
        }
        return count;

    }
}
