import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map to track (num, frequency)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        // Use a minheap sorted by frequency [num, frequency]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int num : map.keySet()) {
            minHeap.add(new int[]{num, map.get(num)});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int[] top = minHeap.poll();
            result[i] = top[0];
        }
        return result;
    }
}