class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            helper(heights, r, 0, heights[r][0], pacific);
            helper(heights, r, m - 1, heights[r][m - 1], atlantic);
        }

        for (int c = 0; c < m; c++) {
            helper(heights, 0, c, heights[0][c], pacific);
            helper(heights, n - 1, c, heights[n - 1][c], atlantic);
        }

        List<List<Integer>> output = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    output.add(cell);
                }
            }
        }

        return output;
    }

    private void helper(int[][] heights, int r, int c, int prev, boolean[][] visited) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length) {
            return;
        }

        if (visited[r][c] || heights[r][c] < prev) {
            return;
        }

        visited[r][c] = true;
        helper(heights, r - 1, c, heights[r][c], visited);
        helper(heights, r + 1, c, heights[r][c], visited);
        helper(heights, r, c - 1, heights[r][c], visited);
        helper(heights, r, c + 1, heights[r][c], visited);
    }
}








