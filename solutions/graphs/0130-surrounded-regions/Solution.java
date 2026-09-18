class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        // Check border cells and mark any regions connected to the border as safe.
        for (int row = 0; row < ROWS; row++) {
            // Left and right edge
            markSafe(board, row, 0, ROWS, COLS);
            markSafe(board, row, COLS - 1, ROWS, COLS);
        }

        for (int col = 0; col < COLS; col++) {
            // Top and bottom edge
            markSafe(board, 0, col, ROWS, COLS);
            markSafe(board, ROWS - 1, col, ROWS, COLS);
        }

        // Final pass through the board
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == '#') {
                    board[row][col] = 'O';
                } 
            }
        }
    }

    private void markSafe(char[][] board, int row, int col, int ROWS, int COLS) {
        // Base case
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || board[row][col] != 'O') {
            return;
        }
        
        // Mark the current cell as safe with '#' (part of a border region)
        board[row][col] = '#';

        // Recursive case
        markSafe(board, row + 1, col, ROWS, COLS);
        markSafe(board, row - 1, col, ROWS, COLS);
        markSafe(board, row, col + 1, ROWS, COLS);
        markSafe(board, row, col - 1, ROWS, COLS);
    }
}