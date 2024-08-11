//intitution was simple if there are already more than 1 island in grid than we have to do zero work otherwise flip all 1s and check after flipping if islandcount>1 i.e graph is disconnected into 2 island
//therefore return 1 otherwise maximum flipping required will always be 2 because with max 2 flips we can disconnect it into 2 island
class Solution {
    public int minDays(int[][] grid) {
        if(islandcount(grid)!=1){
            return 0;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(islandcount(grid)!=1){
                        return 1;
                    }
                    grid[i][j]=1;
                }
            }
        }
        return 2;
    }
    public int islandcount(int grid[][]){
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==false && grid[i][j]==1){
                    ans++;
                    dfs(visited,grid,i,j);
                }
            }
        }
        return ans;
    }
    public void dfs(boolean visited[][],int grid[][],int row,int col){
        if(row<0 || row==grid.length || col<0 || col==grid[0].length || visited[row][col] || grid[row][col]==0){
            return;
        }
        visited[row][col]=true;
        dfs(visited,grid,row+1,col);
        dfs(visited,grid,row,col+1);
        dfs(visited,grid,row,col-1);
        dfs(visited,grid,row-1,col);
    }
}
