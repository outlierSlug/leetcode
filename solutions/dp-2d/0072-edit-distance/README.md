<!--
number: 0072
title: Edit Distance
pattern: dp-2d
difficulty: Medium
languages: Java
slug: edit-distance
last_reviewed: 2026-11-05
-->
# Edit Distance
[Problem Description](https://leetcode.com/problems/edit-distance/description/)

Summary: Given two strings `word1` and `word2`, return the minimum number of operations required to convert `word1` into `word2`. The allowed operations are inserting a character, deleting a character, and replacing a character.

## Algorithm
Bottom-up 2D DP over suffixes.

Let `dp[i][j]` be the edit distance between the suffixes `word1[i..]` and `word2[j..]`. The table has size `(m + 1) × (n + 1)`, where index `m` or `n` represents an empty suffix.

1. **Base cases:** the bottom row and right column cover empty suffixes. If `word1` is used up, the remaining characters of `word2` must be inserted. If `word2` is used up, the remaining characters of `word1` must be deleted.
2. **Fill order:** each cell depends on the cells below, to the right, and diagonally below-right, so fill rows from `m - 1` down to 0 and columns from `n - 1` down to 0.
3. **Each cell:** if the current characters match, no operation is needed, so take the diagonal. Otherwise, apply one operation and take the cheapest remaining subproblem:
   - **Replace** `word1[i]` with `word2[j]`: both characters are now matched, so move diagonally.
   - **Delete** `word1[i]`: move down, since `word2[j]` is still unmatched.
   - **Insert** `word2[j]` before `word1[i]`: move right, since `word1[i]` is still waiting.
4. Return `dp[0][0]`.

## Recurrence

$$
dp[m][j] = n - j, \qquad dp[i][n] = m - i
$$

$$
dp[i][j] =
\begin{cases}
dp[i+1][j+1] & \text{if } \text{word1}[i] = \text{word2}[j] \\[4pt]
1 + \min\big(dp[i+1][j+1],\ dp[i+1][j],\ dp[i][j+1]\big) & \text{otherwise}
\end{cases}
$$

The three terms in the minimum correspond to replace, delete, and insert.

## Complexity
Let `m` and `n` be the lengths of `word1` and `word2`.

| Time | Space |
|---|---|
| $O(mn)$ | $O(mn)$ |

## Notes
- **Space optimization:** each cell reads only the row below and the cell to its right. A single row of length `n + 1`, plus a variable holding the old diagonal value before it is overwritten, reduces space to $O(n)$. Swapping the strings so the shorter one sets the row length gives $O(\min(m, n))$.
