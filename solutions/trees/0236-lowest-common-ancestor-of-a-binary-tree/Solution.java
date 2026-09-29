class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // If the current node is either p or q, return it up
        if (root == p || root == q) {
            return root;
        }
        
        // Recurse down the left and right subtrees of root
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both the left and right subtrees return non-null values, the current root is the LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise, return the non-null value from one side of the tree, which is the LCA
        // if both p and q are on the same side of the tree. 
        return (left != null) ? left : right;
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