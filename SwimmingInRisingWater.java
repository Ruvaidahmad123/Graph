//dfs solution
class Solution {
    public int swimInWater(int[][] grid) {
        int time = 0;
        int N = grid.length;
        Set<Integer> visited = new HashSet<>();
        while(!visited.contains(N*N-1)) {
            visited.clear();
            dfs(grid, 0, 0, time, visited);
            time++;
        }
        return time - 1;
    }
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    private void dfs(int[][] grid, int i, int j, int time, Set<Integer> visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] > time || visited.contains(i*grid.length+j)) return;
        visited.add(i*grid.length+j);
        for (int[] dir : dirs) {
            dfs(grid, i+dir[0], j+dir[1], time, visited);
        }
    }
}
//dsu solution
class Solution {
    class UF {
        int[] id;
        public UF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }
        public int root(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        public boolean isConnected(int p, int q) {
            return root(p)==root(q);
        }
        public void union(int p, int q) {
            if (isConnected(p, q)) return;
            id[root(p)] = root(q);
        }
    }
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        UF uf = new UF(N*N);
        int time = 0;
        while(!uf.isConnected(0, N*N-1)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] > time) continue;
                    if (i < N-1 && grid[i+1][j]<=time) uf.union(i*N+j, i*N+j+N);
                    if (j < N-1 && grid[i][j+1]<=time) uf.union(i*N+j, i*N+j+1);
                }
            }
            time++;
        }
        if(time==0)return 0;
        return time - 1;
    }
}
