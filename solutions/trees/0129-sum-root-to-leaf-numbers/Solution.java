class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }
        
        // Accumulate the current root-to-leaf number
        current = current * 10 + node.val;
        
        // If the current node is a leaf, return the sum
        if (node.left == null && node.right == null) {
            return current;
        }

        // Recurse down children and sum the results
        return dfs(node.left, current) + dfs(node.right, current);
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