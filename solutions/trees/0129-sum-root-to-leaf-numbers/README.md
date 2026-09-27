<!--
number: 0129
title: Sum Root to Leaf Numbers
pattern: trees
difficulty: Medium
languages: Java
slug: sum-root-to-leaf-numbers
last_reviewed: 2026-09-26
-->
# Sum Root to Leaf Numbers
[Problem Description](https://leetcode.com/problems/sum-root-to-leaf-numbers/description/)

Summary: Given the root of a binary tree where each node holds a digit from `0` to `9`, each root-to-leaf path spells out a number (for example, `1 -> 2 -> 3` is `123`). Return the sum of all root-to-leaf numbers.

## Algorithm
DFS that builds each path's number on the way down. A helper `dfs(node, current)` takes the number built so far and extends it with the current node's digit using `current = current * 10 + node.val`. Multiplying by 10 shifts the existing digits one place to the left, and adding `node.val` fills in the new ones digit. The first call passes `current = 0`, so the root's digit comes out correctly.

- **Null node:** returns `0`. For a node with only one child, the missing side adds nothing, so a non-leaf node is never counted as the end of a number. Also handles the null root case.
- **Leaf node:** returns `current`, the complete number for that path.
- **Internal node:** returns `dfs(left) + dfs(right)`, the sum of all numbers that pass through this node.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(h)$ |

Every node is visited once, with constant work per node. Space comes from the recursion stack, which grows with the tree's height `h`: $O(\log n)$ for a balanced tree, and $O(n)$ for a skewed one.
## Notes
- **Math instead of strings:** building a `String` of digits and parsing it at each leaf also works, but it allocates memory at every step. The `current * 10 + node.val` update is constant work, and since `int`s are passed by value, each call gets its own copy of `current`, so there's no undo step when a call returns.
- **Overflow:** LeetCode guarantees the answer fits in a 32-bit `int` (tree depth is at most 10). Without that guarantee, both a single path's number and the running total could overflow. Switching `current` and the return type to `long` covers paths of up to 18 digits. Beyond that, use `BigInteger`, or apply `% MOD` after each operation if the problem asks for the answer modulo a value.
