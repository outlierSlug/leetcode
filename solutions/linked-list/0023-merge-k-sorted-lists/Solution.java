import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add the first node in every list to the minHeap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!minHeap.isEmpty()) {
            // Poll and append the current node to the merged list
            ListNode curr = minHeap.poll();
            tail.next = curr;
            tail = tail.next;

            // Add curr.next to the minHeap if it exists
            if (curr.next != null) {
                minHeap.offer(curr.next);
            }
        }

        return dummy.next;
    }
}

/**
 * Definition for a singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}