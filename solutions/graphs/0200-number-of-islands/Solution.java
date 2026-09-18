class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int count = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col, ROWS, COLS);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col, int ROWS, int COLS) {
        // Base case
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || grid[row][col] != '1') {
            return;
        }

        // Mark current cell as visited
        grid[row][col] = '0';

        // Recursive Case
        dfs(grid, row + 1, col, ROWS, COLS);
        dfs(grid, row - 1, col, ROWS, COLS);
        dfs(grid, row, col + 1, ROWS, COLS);
        dfs(grid, row, col - 1, ROWS, COLS);
    }
}