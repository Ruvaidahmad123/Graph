class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public boolean isValid(int nrow,int ncol,int n){
        return nrow>=0 && nrow<n && ncol>=0 && ncol<n;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)continue;
                int delrow[]={-1,0,1,0};
                int delcol[]={0,-1,0,1};
                for(int ind=0;ind<4;ind++){
                    int nrow=i+delrow[ind];
                    int ncol=j+delcol[ind];
                    if(isValid(nrow,ncol,n)&& grid[nrow][ncol]==1){
                        int nodenum=i*n+j;
                        int adjnodenum=nrow*n+ncol;
                        ds.unionBySize(nodenum,adjnodenum);
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1)continue;
                int delrow[]={-1,0,1,0};
                int delcol[]={0,-1,0,1};
                HashSet<Integer>components=new HashSet<>();
                for(int ind=0;ind<4;ind++){
                    int nrow=i+delrow[ind];
                    int ncol=j+delcol[ind];
                    if(isValid(nrow,ncol,n)){
                        if(grid[nrow][ncol]==1){
                            components.add(ds.findUPar(nrow*n+ncol));
                        }
                    }
                }
                int size=1;
                for(Integer parents:components){
                    size+=ds.size.get(parents);
                }
                max=Math.max(max,size);
            }
        }
        return max==0?n*n:max;
    }
}
