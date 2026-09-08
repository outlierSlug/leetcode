import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            result.add(List.of(curr[0], curr[1]));
            int nums2Index = curr[2];
            if (nums2Index + 1 < nums2.length) {
                minHeap.offer(new int[]{curr[0], nums2[nums2Index + 1], nums2Index + 1});
            }
            k--;
        }
        return result;
    }
}