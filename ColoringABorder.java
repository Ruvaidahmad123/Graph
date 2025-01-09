class Pair {
    int i, j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Pair> borderCells = new ArrayList<>();
        int initialColor = grid[row][col];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        visited[row][col] = true;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.i, c = p.j;
            boolean isBorder = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + delRow[i];
                int nc = c + delCol[i];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != initialColor) {
                    isBorder = true;
                } else if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
            if (isBorder) {
                borderCells.add(new Pair(r, c));
            }
        }
        for (Pair cell : borderCells) {
            grid[cell.i][cell.j] = color;
        }
        return grid;
    }
}
