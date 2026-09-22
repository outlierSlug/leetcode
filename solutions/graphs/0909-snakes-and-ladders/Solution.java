import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(1);
        visited.add(1);

        // Standard BFS loop
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == target) {
                    return moves;
                }
                // Test all moves from the current square.
                for (int next = current + 1; next <= Math.min(current + 6, target); next++) {
                    // Get the number of the destination of the square.
                    int destination = getSquareValue(board, next, n);
                    // Add the destination from this move to the visited set and queue.
                    if (!visited.contains(destination)) {
                        visited.add(destination);
                        queue.offer(destination);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    // Get the value of the current square based on the Boustrophedon grid.
    private int getSquareValue(int[][] board, int square, int n) {
        // Get the raw row and column index of the square, treating the bottom row as row 0.
        int r = (square - 1) / n;
        int c = (square - 1) % n;

        // If the square is on an odd row, the numbers go right-to-left. "Flip" the column index.
        if (r % 2 == 1) {
            c = n - 1 - c;
        }

        // Since the bottom row is actually (n - 1) instead of 0, flip the raw row index.
        int val = board[n - 1 - r][c];

        // If the value at this square is -1, there is no snake or ladder. However, if there is another number,
        // return the value at this square, which is the destination via a snake or ladder at this square.
        return val == -1 ? square : val;
    }
}