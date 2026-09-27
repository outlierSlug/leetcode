<!--
number: 0112
title: Path Sum
pattern: trees
difficulty: Easy
languages: Java
slug: path-sum
last_reviewed: 2026-09-26
-->
# Path Sum
[Problem Description](https://leetcode.com/problems/path-sum/description/)

Summary: Given the root of a binary tree and an integer `targetSum`, return `true` if some root-to-leaf path has values that add up to `targetSum`.

## Algorithm
Depth-first search, carrying the sum of the current path down the tree. A helper `dfs(node, currentSum, targetSum)` adds `node.val` to the running sum and then:

- **Null node:** returns `false`. There's no path through a missing child, and this also covers an empty tree.
- **Leaf (no children):** returns whether `currentSum == targetSum`. The sum is only checked at leaves, since a valid path must end at one.
- **Internal node:** recurses into both children with the updated sum and combines the results with `||`. A valid path in either subtree is enough, and `||` stops as soon as the left side finds one.


## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(h)$ |

Worst-case runtime is $O(n)$ in the case of visiting every node. Space complexity is from the recursive call stack, where `h` is the height of the tree; $O(\log n)$ for a balanced tree, and $O(n)$ in the worst-case for a skewed one.

## Notes
- [Neetcode Solution](https://www.youtube.com/watch?v=LSKQyOz_P8I)
- Alternate Solution: Subtract each node's value from `targetSum` on the way down, so each call asks "does a path in this subtree add up to the remaining amount?" At a leaf, check `targetSum == root.val`. The logic is the same, just shorter.

```java
public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    if (root.left == null && root.right == null) return targetSum == root.val;
    int remaining = targetSum - root.val;
    return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
}
```
