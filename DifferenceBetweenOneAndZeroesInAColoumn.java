class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
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
        int diff[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                diff[i][j]=iones[i]+jones[j]-(m-iones[i])-(n-jones[j]);
            }
        }
        return diff;
    }
}
