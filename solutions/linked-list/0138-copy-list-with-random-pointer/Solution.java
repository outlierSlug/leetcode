import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copies = new HashMap<>();

        // Pass 1: Build copies map
        Node curr = head;
        while (curr != null) {
            copies.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Pass 2: Populate pointers
        curr = head;
        while (curr != null) {
            Node copy = copies.get(curr);
            copy.next = copies.get(curr.next);
            copy.random = copies.get(curr.random);
            curr = curr.next;
        }

        return copies.get(head);
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}