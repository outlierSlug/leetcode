import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = merged.get(merged.size() - 1);

            if (current[0] <= last[1]) {
                last[1] = Math.max(current[1], last[1]);
            } else {
                merged.add(current);
            }
        }
        return merged.toArray(new int[0][]);
    }
}