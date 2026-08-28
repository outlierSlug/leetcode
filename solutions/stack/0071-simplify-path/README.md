<!--
number: 0071
title: Simplify Path
pattern: stack
difficulty: Medium
languages: Java
slug: simplify-path
last_reviewed: 2026-08-27
-->
# Simplify Path
[Problem Description](https://leetcode.com/problems/simplify-path/description/)

Summary: Given an absolute Unix-style path, collapse it into its canonical simplified path.

## Algorithm
Split the path on `/` to get individual tokens. Then, we will iterate through the tokens with a stack as follows:
1. Skip empty tokens (produced by consecutive slashes) and `.` tokens.
2. On `..`, we pop the stack if its non-empty, which is functionally going back to the parent directory.
3. On any other token, we simply push it onto the stack as it is a valid directory name.

After processing all the tokens, the stack holds the path components in reverse order, so we convert the stack into a list, reverse it, and join with `/`, prefiing with a leading `/`. If the stack is empty, this correctly returns `/`.

## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(n)` |

## Notes
Excess `..` tokens at the root level results in a no-op.
