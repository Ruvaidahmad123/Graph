class Solution {
    public int numSpecial(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int iones[]=new int[m];
        for(int i=0;i<m;i++){
            int numberOfOnes=0;
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    numberOfOnes++;
                }
            }
            iones[i]=numberOfOnes;
        }
        int jones[]=new int[n];
        for(int j=0;j<n;j++){
            int numberOfOnes=0;
            for(int i=0;i<m;i++){
                if(grid[i][j]==1){
                    numberOfOnes++;
                }
            }
            jones[j]=numberOfOnes;
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && iones[i]==1 && jones[j]==1)cnt++;
            }
        }
        return cnt;
    }
}
