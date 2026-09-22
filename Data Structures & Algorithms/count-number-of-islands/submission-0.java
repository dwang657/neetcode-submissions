class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    helper(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        helper(grid, r, c + 1);
        helper(grid, r, c - 1);
        helper(grid, r - 1, c);
        helper(grid, r + 1, c);
    }
}
