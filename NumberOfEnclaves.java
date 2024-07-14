//same as surrounded region problem
class Solution {
     public void dfs(int row, int col, int n, int m, int[][] grid, boolean[][] visited, int[] delrow, int[] delcol) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && !visited[nrow][ncol]) {
                dfs(nrow, ncol, n, m, grid, visited, delrow, delcol);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        // First row and last row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                dfs(0, j, n, m, grid, visited, delrow, delcol);
            }
            if (grid[n-1][j] == 1  && !visited[n-1][j]) {
                dfs(n-1, j, n, m, grid, visited, delrow, delcol);
            }
        }

        // First column and last column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                dfs(i, 0, n, m, grid, visited, delrow, delcol);
            }
            if (grid[i][m-1] == 1 && !visited[i][m-1]) {
                dfs(i, m-1, n, m, grid, visited, delrow, delcol);
            }
        }

        // Flip all 'O' to 'X' if they are not visited
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
