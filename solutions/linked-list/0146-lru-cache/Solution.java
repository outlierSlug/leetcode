class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;  // (key, reference to Node with value) dictionary
    private Node dummyHead, dummyTail;  // dummy head and tail of the doubly linked list

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummyHead = new Node(-1, -1);
        this.dummyTail = new Node(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            // Case 1: Key does not exist, return -1
            return -1;
        } else {
            // Case 2: Get the key's value and move it to the front
            if (dummyHead.next == node) return node.val;
            remove(node);
            addToFront(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            // Case 1: New key, add it to the map and linked list
            node = new Node(key, value);
            map.put(key, node);

            // place node at front of linked list
            addToFront(node);

            // if over capacity, evict LRU node
            if (map.size() > capacity) {
                Node lru = dummyTail.prev;
                remove(lru);
                map.remove(lru.key);
            }
        } else {
            // Case 2: Key already exists, update its value
            node.val = value;

            // Move this key's node to the front of the list
            if (dummyHead.next == node) return;
            remove(node);
            addToFront(node);
        }
    }

    // Unlinks node from the list. Dummy head/tail guarantees prev and next are non-null.
    private void remove(Node node) {
        Node left = node.prev;
        Node right = node.next;
        left.next = right;
        right.prev = left;
    }

    // Inserts node right after head (the most recently used position).
    private void addToFront(Node node) {
        Node oldFront = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        node.next = oldFront;
        oldFront.prev = node;
    }

    // Class definition for a doubly-linked list node.
    private static class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) { this.key = key; this.val = val; }
    }
}