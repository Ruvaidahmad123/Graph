class Solution {
    // Direction vectors for moving in the grid
    private static final int[] DIRECTIONS_X = { -1, 1, 0, 0 };
    private static final int[] DIRECTIONS_Y = { 0, 0, -1, 1 };

    public int minimumCostPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Priority queue to store cells with their current cost
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.cost));
        // Distance matrix initialized to infinity
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Start from the top-left corner
        pq.add(new Cell(0, 0, grid[0][0]));
        dist[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int x = current.x;
            int y = current.y;
            int cost = current.cost;

            // If we reached the bottom-right corner
            if (x == m - 1 && y == n - 1) {
                return cost;
            }

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int newX = x + DIRECTIONS_X[i];
                int newY = y + DIRECTIONS_Y[i];
                if (isValid(newX, newY, m, n)) {
                    int newCost = cost + grid[newX][newY];
                    if (newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost;
                        pq.add(new Cell(newX, newY, newCost));
                    }
                }
            }
        }

        // If somehow no path was found (should not happen with valid input)
        return -1;
    }

    // Check if the new cell is within grid boundaries
    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // Helper class to represent a cell in the priority queue
    private static class Cell {
        int x, y, cost;

        Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
