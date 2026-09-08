import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    // Separate data into left half (maxHeap) and right half (minHeap).
    // The largest element of the left half must always be less than or equal to
    // the smallest element in the right half, and the two halves must be of equal size,
    // plus or minus one extra element.
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        // Rebalance left and right halves if necessary
        if (maxHeap.peek() != null && minHeap.peek() != null && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */