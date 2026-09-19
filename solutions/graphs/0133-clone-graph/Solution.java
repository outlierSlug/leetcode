import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Node, Node> visited) {
        // Base case: this node already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        // Copy current node and put it in the visited map
        Node clone = new Node(node.val);
        visited.put(node, clone);
        for (Node neighbor : node.neighbors) {
            // Recursively add the current node's neighbors
            clone.neighbors.add(dfs(neighbor, visited));
        }
        // Return the clone that was just created to the caller.
        // This will either be appended to a neighbor list or is
        // the reference to the first node returned to cloneGraph.
        return clone;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}