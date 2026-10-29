class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode before = dummy;

        while (true) {
            // Check if there are at least k nodes after before
            ListNode probe = before;
            for (int i = 0; i < k; i++) {
                if (probe == null) break;
                probe = probe.next;
            }

            if (probe == null) break;
            
            // The first node in the sublist to be reversed
            ListNode first = before.next;

            // Reverse exactly k nodes starting at first
            ListNode prev = null;
            ListNode curr = first;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // prev is now the front of the reversed sublist. curr now points
            // to the node right after the end of the reversed sublist.
            first.next = curr;
            before.next = prev;

            // Move before to the end of the most recently reversed sublist
            before = first;
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