class Solution {
    private TreeNode prev;
    private int minDiff;
    
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inorder(root);
        return minDiff;
    }

    // Performs an in-order traversal of the tree, calculating the difference between consecutive elements.
    private void inorder(TreeNode node) {
        if (node == null) return;
        
        inorder(node.left);

        // Calculate the difference and update minDiff
        if (prev != null) {
            int diff = node.val - prev.val;
            minDiff = Math.min(minDiff, diff);
        }
        
        // Set the current node as the new previous node
        prev = node;

        inorder(node.right);
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