import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // Sort intervals by end time
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        int prev = points[0][1];

        // Always shoot at the end of the next non-overlapping interval
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prev) {
                arrows++;
                prev = points[i][1];
            }
        }

        return arrows;
    }
}