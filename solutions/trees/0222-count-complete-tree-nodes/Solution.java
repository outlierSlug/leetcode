class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getLeftDepth(root);
        int rightDepth = getRightDepth(root);

        // If the left and right depths are equal, we have a perfect tree. 
        if (leftDepth == rightDepth) {
            // count = 2^{depth} - 1
            return (1 << leftDepth) - 1;
        }

        // Otherwise, recurse into the current node's children
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Get the count of the left chain starting at node
    private int getLeftDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    // Get the count of the right chain starting at node
    private int getRightDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
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