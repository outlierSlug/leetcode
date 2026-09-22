<!--
number: 0070
title: Climbing Stairs
pattern: dp-1d
difficulty: Easy
languages: Java
slug: climbing-stairs
last_reviewed: 2026-09-22
-->
# Climbing Stairs
[Problem Description](https://leetcode.com/problems/climbing-stairs/description/)

Summary: Given a staircase of `n` steps, where each move climbs 1 or 2 steps, return the number of distinct ways to reach the top.

## Algorithm
Classic DP problem with a Fibonacci-like recurrence. We will use a bottom-up approach, storing $\text{dp}(i)$ in `dp[i]`.
Base cases are returned early, before allocating the array, since unconditionally writing `dp[2]` on an array sized for `n = 1` would go out of bounds.

## Recurrence
Let $\text{dp}(i)$ be the number of distinct ways to reach step $i$, for $1 \le i \le n$.

```math
\text{dp}(i) = \begin{cases}
    1 & i = 1 \\
    2 & i = 2 \\
    \text{dp}(i-1) + \text{dp}(i-2) & i > 2
\end{cases}
```
**Base Cases:** $\text{dp}(1) = 1$ (only one way: a single 1-step move) and $\text{dp}(2) = 2$ (either two 1-steps, or one 2-step).

**Recursive Case:** The last move to reach step $i$ was either a single 1-step from step $i-1$, or a single 2-step from step $i-2$. These two cases are exhaustive (every path to step $i$ ends in exactly one of these two ways) and mutually exclusive, so summing the ways to reach each predecessor gives the total ways to reach $i$.

**Final Answer**: The final answer is stored in $\text{dp}(n)$.

## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(n)` |

## Notes
- **Space optimization**: since `dp[i]` only ever depends on the two immediately preceding values, the full array is unnecssary and could be collapsed to two rolling variables. This optimizes space complexity to `O(1)`.
