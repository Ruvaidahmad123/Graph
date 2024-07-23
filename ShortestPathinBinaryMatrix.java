//bfs approach
class Pair {
    int dist;
    int row;
    int col;

    Pair(int d, int r, int c) {
        dist = d;
        row = r;
        col = c;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1; // Start or end is blocked
        }

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, 
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        q.add(new Pair(1, 0, 0));

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int dist = current.dist;
            int row = current.row;
            int col = current.col;

            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            for (int[] dir : directions) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && !visited[nrow][ncol] && grid[nrow][ncol] == 0) {
                    visited[nrow][ncol] = true;
                    q.add(new Pair(dist + 1, nrow, ncol));
                }
            }
        }

        return -1;
    }
}
