class Solution {
    private int maxSum;  // the best path sum found anywhere in the tree so far

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;  // handles all-negative values
        dfs(root);
        return maxSum;
    }

    // Returns the max sum of a single downard path starting at node
    private int dfs(TreeNode node) {
        // Base case: empty subtree contributes nothing
        if (node == null) {
            return 0;
        }

        // Get the best gain from each side, clamp negative gains to 0
        int leftMax = Math.max(dfs(node.left), 0);
        int rightMax = Math.max(dfs(node.right), 0);

        // Update maxSum with the current candidate path with node as the "peak"
        maxSum = Math.max(maxSum, node.val + leftMax + rightMax);
        
        // Return the better single path that continues up to the parent
        return node.val + Math.max(leftMax, rightMax);
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