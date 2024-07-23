class Pair{
    int diff;
    int row;
    int col;
    Pair(int d,int r,int c){
        diff=d;
        row=r;
        col=c;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int distance[][]=new int[n][m];
        for(int i=0;i<distance.length;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=(int)1e9;
            }
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.diff-b.diff);
        pq.add(new Pair(0,0,0));
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!pq.isEmpty()){
            int diff=pq.peek().diff;
            int row=pq.peek().row;
            int col=pq.peek().col;
            pq.poll();
            if(row==n-1 && col==m-1){
                return diff;
            }
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow<n && nrow>=0 && ncol>=0 && ncol<m){
                    int neweffort=Math.max(Math.abs(heights[nrow][ncol]-heights[row][col]),diff);
                    if(neweffort<distance[nrow][ncol]){
                        distance[nrow][ncol]=neweffort;
                        pq.add(new Pair(neweffort,nrow,ncol));
                    }
                }
            }
        }
        return -1;
    }
}
