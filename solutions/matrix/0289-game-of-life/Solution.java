class Solution {
    public void gameOfLife(int[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int neighbors = countNeighbors(board, row, col, ROWS, COLS);
                int currentCell = board[row][col] % 2;

                if (currentCell == 1) {
                    // Live cell with exactly 2 or 3 neighbors lives on (3 decoded becomes 1)
                    if (neighbors == 2 || neighbors == 3) {
                        board[row][col] = 3;
                    }
                    // Otherwise, it will die (1 decoded becomes 0)
                } else if (currentCell == 0) {
                    // Dead cell with exactly 3 neighbors becomes alive (2 decoded becomes 1)
                    if (neighbors == 3) {
                        board[row][col] = 2;
                    }
                    // Otherwise, it remains dead (0 decoded remains 0)
                }
            }
        }

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int currentCell = board[row][col];
                if (currentCell == 1) {
                    board[row][col] = 0;
                } else if (currentCell == 2 || currentCell == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }

    // Count the living neighbors of the current cell at board[row][col]. Checks all 8 directions.
    private int countNeighbors(int[][] board, int row, int col, int ROWS, int COLS) {
        int count = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                int r = row + dr;
                int c = col + dc;
                if ((r >= 0 && r < ROWS) && (c >= 0 && c < COLS)) {
                    if (board[r][c] % 2 == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}