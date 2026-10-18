import java.util.HashMap;
import java.util.Map;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // value -> index in inorder
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0 ; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return construct(postorder, inorderIndex, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] postorder, Map<Integer, Integer> inorderIndex, int postEnd, int inLeft, int inRight) {
        if (inRight - inLeft < 0) {
            return null;
        }

        // Postorder traversal visits the root last, so the subtree's root is at postEnd
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderIndex.get(rootVal);
        int rightSize = inRight - rootIndex;

        root.left = construct(postorder, inorderIndex, postEnd - rightSize - 1, inLeft, rootIndex - 1);
        root.right = construct(postorder, inorderIndex, postEnd - 1, rootIndex + 1, inRight);
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