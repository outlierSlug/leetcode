class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        // Invariant: prev.next == curr
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                // curr starts a duplicate run: advance to the run's last node.
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // Unlink the entire run.
                prev.next = curr.next;
            } else {
                // curr is unique, so keep it and move prev to it.
                prev = prev.next;
            }
            curr = curr.next;
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