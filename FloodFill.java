class Solution {
    public void dfs(int sr,int sc,int newcolor,int ans[][],int delrow[],int delcol[],int ini_color){
        ans[sr][sc]=newcolor;
        int n=ans.length;
        int m=ans[0].length;
        for(int i=0;i<4;i++){
            int nrow=sr+delrow[i];
            int ncol=sc+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]!=newcolor && ans[nrow][ncol]==ini_color){
                dfs(nrow,ncol,newcolor,ans,delrow,delcol,ini_color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        int ini_color=image[sr][sc];
        int ans[][]=image;
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};
        dfs(sr,sc,newcolor,ans,delrow,delcol,ini_color);
        return ans;
    }
}
