import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Add all projects to the minHeap 
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        // Take the k most profitable projects that are affordable at each step
        for (int i = 0; i < k; i++) {
            // Add affordable projects to the maxHeap, ordered by profit
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                int[] project = minCapitalHeap.poll();
                maxProfitHeap.offer(new int[]{project[1], project[0]});
            }
            if (maxProfitHeap.isEmpty()) break;  // no affordable projects exist
            w += maxProfitHeap.poll()[0];
        }
        return w;
    }
}