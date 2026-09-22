class Solution {
    public int orangesRotting(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    rotAdjacent(grid, r, c, 2);
                }
            }
        }

        int mins = 2;
        for (int[] r : grid) {
            for (int c : r) {
                if (c == 1) {
                    return -1;
                }
                mins = Math.max(mins, c);
            }
        }

        return mins - 2;
    }

    private void rotAdjacent(int[][] grid, int r, int c, int mins) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }

        if (grid[r][c] == 0 || grid[r][c] > 1 && grid[r][c] < mins) {
            return;
        }

        grid[r][c] = mins;
        rotAdjacent(grid, r - 1, c, mins + 1);
        rotAdjacent(grid, r + 1, c, mins + 1);
        rotAdjacent(grid, r, c - 1, mins + 1);
        rotAdjacent(grid, r, c + 1, mins + 1);
    }
}
