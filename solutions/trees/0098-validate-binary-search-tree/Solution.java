class Solution {
    private TreeNode prev;  // last node visited in-order

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    // Returns true if every node.val in-order is strictly greater than the previous node.
    private boolean inorder(TreeNode node) {
        if (node == null) return true;
        
        // Validate left subtree
        if (!inorder(node.left)) return false;
        
        // Process the current node, compare it to prev
        if (prev != null && prev.val >= node.val) return false;
        prev = node;
        
        // Validate right subtree
        return inorder(node.right);
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}