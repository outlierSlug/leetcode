<!--
number: 0198
title: House Robber
pattern: dp-1d
difficulty: Medium
languages: Java
slug: house-robber
last_reviewed: 2026-09-22
-->
# House Robber
[Problem Description](https://leetcode.com/problems/house-robber/description/)

Summary: Given an array `nums` of money in each house along a street, where adjacent houses can't both be robbed, return the maximum you can rob.

## Algorithm
Dynamic Programming: bottom-up, left to right, storing $\text{dp}(i)$ in `dp[i]`.

## Recurrence
Let $\text{dp}(i)$ be the maximum amount robbable from house $0$ up to house $i$ for $0 \leq i \leq n - 1$.

```math
\text{dp}(i) = \begin{cases}
  \text{nums}[0] & i = 0 \\
  \max(\text{nums}[0], \text{nums}[1]) & i = 1 \\
  \max(\text{dp}(i - 2) + \text{nums}[i], \text{dp}(i - 1)) & i \geq 2
\end{cases}
```

**Base Cases:** With only house $0$, take it. With houses $0$ and $1$ (adjacent, so at most one can be robbed), take whichever is larger.

**Recursive Case:** At house $i$, either rob it or skip it. Robbing it means adding `nums[i]` to $\text{dp}(i-2)$, the best outcome using houses before $i-1$. Skipping it means taking $\text{dp}(i-1)$ as is. The max of these two options is the best choice at $i$.

**Final Answer:** $\text{dp}(n-1)$, where $n$ is the number of houses.


## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(n)` |

## Notes
- **Space optimization:** since $\text{dp}(i)$ only depends on $\text{dp}(i-1)$ and $\text{dp}(i-2)$, the array is collapsible to two rolling variables, dropping space to `O(1)`.
