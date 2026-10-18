import java.util.HashMap;
import java.util.Map;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // value -> index in inorder
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return construct(preorder, inorderIndex, 0, 0, inorder.length - 1);      
    }

    // Constructs the subtree whose root is preorder[preStart] and whose nodes occupy inorder[inLeft..inRight]
    private TreeNode construct(int[] preorder, Map<Integer, Integer> inorderIndex, int preStart, int inLeft, int inRight) {
        // Empty range: no nodes in this subtree
        if (inRight - inLeft < 0) {
            return null;
        }

        // Preorder traversal visits the root first, so the subtree's root is at preStart.
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // In inorder, everything left of the root is in the left subtree, and everything right of it is in the right subtree.
        int rootIndex = inorderIndex.get(rootVal);
        int leftSize = rootIndex - inLeft;

        // Left subtree: comes right after the root in preorder.
        root.left = construct(preorder, inorderIndex, preStart + 1, inLeft, rootIndex - 1);

        // Right subtree: comes after the root and all leftSize left-subtree nodes in preorder.
        root.right = construct(preorder, inorderIndex, preStart + leftSize + 1, rootIndex + 1, inRight);
        
        return root;
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