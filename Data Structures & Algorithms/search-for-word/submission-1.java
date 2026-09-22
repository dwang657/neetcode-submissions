class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, word, 0, r, c, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int r, int c, boolean[][] visited) {
        if (i >= word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] || board[r][c] != word.charAt(i)) {
            return false;
        }
        visited[r][c] = true;
        boolean exists = dfs(board, word, i + 1, r, c + 1, visited) ||
            dfs(board, word, i + 1, r + 1, c, visited) ||
            dfs(board, word, i + 1, r, c - 1, visited) ||
            dfs(board, word, i + 1, r - 1, c, visited);
        visited[r][c] = false;
        return exists;
    }
}
