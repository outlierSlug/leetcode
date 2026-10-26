class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Base cases: Empty list or single node
        if (head == null) return null;
        if (head.next == null) return head;

        // Find the length of the list and the tail node
        ListNode tail = head;
        int n;
        for (n = 1; tail.next != null; n++) {
            tail = tail.next;
        }
        
        // Close the loop
        tail.next = head;

        // Find the new tail which takes n - (k % n) - 1 steps
        ListNode newTail = head;
        for (int i = 0; i < n - (k % n) - 1; i++) {
            newTail = newTail.next;
        }

        // Break the loop
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
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