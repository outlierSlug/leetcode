import java.util.HashSet;
import java.util.Set;

class Solution {
    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        return backtrack(n, 0, cols, posDiag, negDiag);
    }

    private int backtrack(int n, int row, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < n; col++) {
            int posDiagKey = row + col;
            int negDiagKey = row - col;
            if (cols.contains(col) || posDiag.contains(posDiagKey) || negDiag.contains(negDiagKey)) continue;

            cols.add(col);
            posDiag.add(posDiagKey);
            negDiag.add(negDiagKey);

            count += backtrack(n, row + 1, cols, posDiag, negDiag);

            cols.remove(col);
            posDiag.remove(posDiagKey);
            negDiag.remove(negDiagKey);
        }
        return count;
    }
}