<!--
number: 0222
title: Count Complete Tree Nodes
pattern: trees
difficulty: Medium
languages: Java
slug: count-complete-tree-nodes
last_reviewed: 2026-09-29
-->
# Count Complete Tree Nodes
[Problem Description](https://leetcode.com/problems/count-complete-tree-nodes/description/)

Summary: Given the `root` of a complete binary tree, return the number of nodes, in less than $O(n)$ time. In a complete tree, every level is full except possibly the last, and the last level's nodes are as far left as possible.

## Algorithm
The standard count, `1 + count(left) + count(right)`, with a shortcut that counts entire perfect subtrees without visiting their nodes.

**Perfect-subtree shortcut:** at each node, measure the **leftmost depth** (following `.left`) and the **rightmost depth** (following `.right`), counting nodes along the path, root included. In a complete tree, if the two are equal, the subtree is perfect and has exactly $2^d - 1$ nodes, computed as `(1 << d) - 1`. If they differ, the last level is only partly filled, so fall back to `1 + countNodes(left) + countNodes(right)`.

The depths are measured with two small helpers, `getLeftDepth` and `getRightDepth`, each a `while` loop along one path.

## Complexity

| Time | Space |
|---|---|
| $O(\log^2 n)$ | $O(\log n)$ |

In a complete tree, the last level's boundary (where its filled nodes stop) lies in either the left or the right subtree, so the **other** child is always perfect:
- Boundary in the right subtree: the left child's bottom level is full, so the left child is perfect.
- Boundary in the left subtree: the right child has no nodes on the last level, so it's perfect, one level shorter.

So whenever the recursion splits, one of the two calls returns immediately through the shortcut, and only the other can continue. The recursion follows a single path of at most $h = \lfloor \log_2 n \rfloor + 1$ levels, doing $O(h)$ depth-measuring work at each, for $O(\log^2 n)$ total. The best case, a perfect tree, is $O(\log n)$: the two depths match at the root. Space is the recursion depth, $O(\log n)$.

## Notes
- **Depth counts nodes, not edges:** a single node has depth 1, so `(1 << 1) - 1 = 1`. If depth counted edges (root at 0), the formula would be $2^{d+1} - 1$. Either works if used consistently.
- **Bit shift:** `1 << d` shifts binary `1` left by $d$ places, which equals $2^d$ (for example, `1 << 3` is `1000` in binary, which is 8). Subtracting 1 sets every lower bit: `0111`, which is 7. It stays in whole-number math, unlike `Math.pow`, which returns a `double`. For an `int`, $d$ must be at most 30, which is far beyond this problem's limits.
- **Both children can be perfect:** when the last level fills exactly the left half, the left child is perfect at full height and the right child is perfect one level shorter. Both calls return immediately.
- **Why the complete property matters:** in a general binary tree, matching leftmost and rightmost depths don't mean the subtree is full, so the shortcut would give wrong answers. The simple $O(n)$ count is the only option there.
