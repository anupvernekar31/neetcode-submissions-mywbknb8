class Solution {
    public boolean exist(char[][] board, String word) {
        // Get number of rows
        int rows = board.length;
        // Get number of columns
        int cols = board[0].length;

        // Iterate over all cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start DFS if first letter matches
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        // No match found
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        // If word is completely found
        if (idx == word.length()) return true;

        // Boundary and mismatch check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }

        // Store character and mark visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore in all four directions
        boolean found = dfs(board, word, i + 1, j, idx + 1) ||
                        dfs(board, word, i - 1, j, idx + 1) ||
                        dfs(board, word, i, j + 1, idx + 1) ||
                        dfs(board, word, i, j - 1, idx + 1);

        // Restore character
        board[i][j] = temp;

        return found;
    }
}