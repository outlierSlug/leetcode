class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;  // rows
        int n = matrix[0].length;  // cols
        
        // Check if the first row and column have a zero
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        for (int col = 0; col < n; col++) {
            if (matrix[0][col] == 0) {
                firstRowHasZero = true;
            }
        }

        for (int row = 0; row < m; row++) {
            if (matrix[row][0] == 0) {
                firstColHasZero = true;
            }
        }

        // Check the remaining grid (excluding the first row and column)
        // and for any cell with a zero, set a zero flag on the first row and column of that cell
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // Zero out the rows and columns which were flagged from the previous loop
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Zero out the first row and column if necessary
        if (firstRowHasZero) {
            for (int col = 0; col < n; col++) {
                matrix[0][col] = 0;
            }
        }

        if (firstColHasZero) {
            for (int row = 0; row < m; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}