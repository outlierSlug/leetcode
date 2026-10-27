class Solution {
    public ListNode partition(ListNode head, int x) {
        // Create two lists with a dummy head, one to hold values < x and the other >= x
        ListNode beforeDummy = new ListNode(0);
        ListNode before = beforeDummy;
        ListNode afterDummy = new ListNode(0);
        ListNode after = afterDummy;

        // Single pass through the linked list, append values to before (<) and after (>=)
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Connect the tail of before with the head of after
        before.next = afterDummy.next;

        // End the list
        after.next = null;

        // Return the completed list
        return beforeDummy.next;
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