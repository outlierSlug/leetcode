class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (backtrack(board, word, 0, row, col, ROWS, COLS)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row, int col, int ROWS, int COLS) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = backtrack(board, word, index + 1, row + 1, col, ROWS, COLS)
                     || backtrack(board, word, index + 1, row - 1, col, ROWS, COLS)
                     || backtrack(board, word, index + 1, row, col + 1, ROWS, COLS)
                     || backtrack(board, word, index + 1, row, col - 1, ROWS, COLS);
        
        board[row][col] = temp;
        return found;
    }
}