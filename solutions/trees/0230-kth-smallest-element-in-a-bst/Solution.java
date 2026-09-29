class Solution {
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        // Stop if the current node is null or we already found the result
        if (node == null || count >= k) return;
        
        inorder(node.left, k);
        
        // Stop if the left subtree already found the result
        if (count >= k) return;

        // Process the current node
        count++;
        if (count >= k) {
            result = node.val;
            return;
        }
        
        inorder(node.right, k);
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