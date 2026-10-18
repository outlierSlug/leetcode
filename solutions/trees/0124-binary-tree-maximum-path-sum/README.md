<!--
number: 0124
title: Binary Tree Maximum Path Sum
pattern: trees
difficulty: Hard
languages: Java
slug: binary-tree-maximum-path-sum
last_reviewed: 2026-10-18
-->
# Binary Tree Maximum Path Sum
[Problem Description](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/)

Summary: A *path* in a binary tree is a sequence of nodes where each adjacent pair is connected by an edge, and each node appears at most once. The path does not need to pass through the root and must contain at least one node. Given the root of a binary tree, return the maximum path sum over all paths.

## Algorithm
Postorder DFS with a global maximum.

Every path has exactly one **peak**, its highest node. At the peak, the path can extend down into the left subtree, the right subtree, both, or neither. This gives two different quantities at each node:

- **Gain (returned to the parent):** the max sum of a downward path starting at the node and continuing into **at most one** child. A parent can extend this path upward, so it cannot branch.
- **Peak path (candidate answer):** the max sum of a path whose peak is this node, using **both** sides. It cannot extend to the parent, since the node would then need three path edges.

**Steps:**
- Initialize `maxSum` to `Integer.MIN_VALUE`, since the answer can be negative.
- `dfs(node)`:
  - **Base case:** a `null` node returns 0.
  - Recursively compute the gains from the left and right children, clamping each at 0. A negative gain would only lower the sum, so the path skips that side.
  - Update `maxSum` with `node.val + leftMax + rightMax`.
  - Return `node.val + max(leftMax, rightMax)`.
- Return `maxSum`.

## Recurrence

Let $g(v)$ be the max downward path sum starting at node $v$:

$$
g(\text{null}) = 0
$$

$$
g(v) = v.\text{val} + \max\big(0,\ g(v.\text{left}),\ g(v.\text{right})\big)
$$

The answer takes the best peak path over all nodes:

$$
\text{answer} = \max_{v} \Big( v.\text{val} + \max\big(0, g(v.\text{left})\big) + \max\big(0, g(v.\text{right})\big) \Big)
$$

Every path has a unique peak, and every node is evaluated as a peak exactly once, so the maximum covers every path.


## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(h)$ |

## Notes
- **Why an instance variable:** the helper's return value is already used for the gain, so the global answer needs to live somewhere else. An alternative is a one-element array (`int[] max`) passed through the recursion.

