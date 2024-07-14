//start from all border o's and do dfs on every possible cell if and mark them visited if they arre not visited at the end this means they can be converted to X 
class Solution {
    public void dfs(int row, int col, int n, int m, char[][] board, boolean[][] visited, int[] delrow, int[] delcol) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O' && !visited[nrow][ncol]) {
                dfs(nrow, ncol, n, m, board, visited, delrow, delcol);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        // First row and last row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(0, j, n, m, board, visited, delrow, delcol);
            }
            if (board[n-1][j] == 'O' && !visited[n-1][j]) {
                dfs(n-1, j, n, m, board, visited, delrow, delcol);
            }
        }

        // First column and last column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, n, m, board, visited, delrow, delcol);
            }
            if (board[i][m-1] == 'O' && !visited[i][m-1]) {
                dfs(i, m-1, n, m, board, visited, delrow, delcol);
            }
        }

        // Flip all 'O' to 'X' if they are not visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
                // Restore all 'O' that are visited
                if (board[i][j] == 'O' && visited[i][j]) {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
