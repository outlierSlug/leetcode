import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        backtrack(n, 0, new int[n], cols, posDiag, negDiag, result);
        return result;
    }

    private void backtrack(int n, int row, int[] placement, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> result) {
        if (row == n) {
            List<String> board = buildBoard(n, placement);
            result.add(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            int posDiagKey = row + col;
            int negDiagKey = row - col;
            if (cols.contains(col) || posDiag.contains(posDiagKey) || negDiag.contains(negDiagKey)) continue;

            placement[row] = col;
            cols.add(col);
            posDiag.add(posDiagKey);
            negDiag.add(negDiagKey);

            backtrack(n, row + 1, placement, cols, posDiag, negDiag, result);

            cols.remove(col);
            posDiag.remove(posDiagKey);
            negDiag.remove(negDiagKey);
        }
    }

    // placement[row] = col
    private List<String> buildBoard(int n, int[] placement) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                sb.append(placement[row] == col ? 'Q' : '.');
            }
            board.add(sb.toString());
        }
        return board;
    }
}