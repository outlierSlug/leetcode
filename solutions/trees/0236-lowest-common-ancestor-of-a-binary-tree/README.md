<!--
number: 0236
title: Lowest Common Ancestor of a Binary Tree
pattern: trees
difficulty: Medium
languages: Java
slug: lowest-common-ancestor-of-a-binary-tree
last_reviewed: 2026-09-28
-->
# Lowest Common Ancestor of a Binary Tree
[Problem Description](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/)

Summary: Given a binary tree and two nodes `p` and `q` that are both in the tree, return their lowest common ancestor: the deepest node that has both `p` and `q` as descendants. A node counts as a descendant of itself.

## Algorithm
Post-order DFS that passes information **up** the tree. The recursive call on a subtree returns:
- `null` if neither `p` nor `q` is in the subtree
- `p` or `q` if exactly one of them is in the subtree
- the LCA if both are in the subtree

**Base cases:**
- **Null node:** return `null`.
- **Node is `p` or `q`:** return the node right away, without searching below it. This is safe because of the problem's guarantee. If the other target is below this node, this node is the LCA, since a node is its own descendant. If the other target is elsewhere, this node is the signal its parent needs.

**Recursive case:** search both subtrees, then combine the results.
- **Both sides non-null:** `p` and `q` are on opposite sides, so this is where they split. The current node is the LCA.
- **Exactly one side non-null:** pass that result up unchanged. It's either the finished LCA (both targets were on that side) or a single target the parent still needs to know about.
- **Both null:** return `null`.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(h)$ |

Each node is visited at most once. Space comes from the recursion stack, which grows with the tree's height `h`: $O(\log n)$ for a balanced tree, and $O(n)$ for a skewed one.

## Notes
- **Compare references, not values:** `p` and `q` are `TreeNode` objects, so the check is `root == p`, not `root.val == p.val`. LeetCode displays them by value, but the method receives the actual nodes.
- **The early return depends on the guarantee:** returning as soon as `p` or `q` is found assumes both are in the tree. Without that guarantee (LeetCode 1644, LCA of a Binary Tree II), `LCA(5, 99)` would return `5`, which looks exactly like the valid answer to `LCA(5, 4)`, even though `99` doesn't exist.
- **Extension, targets may be missing:** recurse into both children *before* checking whether the current node is a target, so the search never stops early and visits every node. Count how many targets are found, and return the result only if the count is 2, otherwise `null`. It's still $O(n)$ time and $O(h)$ space. A simpler alternative is to check that both nodes exist first, then run the original algorithm, at the cost of three passes over the tree instead of one.
- **Direction of information:** Path Sum and Sum Root to Leaf Numbers pass values *down* the tree. This problem passes results *up*: each node decides using only what its children report back. Recognizing which direction a problem needs is often the first step to solving it.
