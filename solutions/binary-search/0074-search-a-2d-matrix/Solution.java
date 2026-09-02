class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int lo = 0;
        int hi = ROWS * COLS - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int row = mid / COLS;
            int col = mid % COLS;
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (val > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}