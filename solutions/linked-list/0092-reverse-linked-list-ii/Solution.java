class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);

        // The node right before the sublist
        ListNode before = dummy;
        for (int i = 0; i < left - 1; i++) {
            before = before.next;
        }

        // The first node in the sublist to be reversed
        ListNode first = before.next;

        // Reverse exactly the right - left + 1 nodes starting at first
        ListNode prev = null;
        ListNode curr = first;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // prev is now the front of the reversed sublist. curr now points to 
        // the node directly after the sublist.
        first.next = curr;
        before.next = prev;

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