<!--
number: 0322
title: Coin Change
pattern: dp-1d
difficulty: Medium
languages: Java
slug: coin-change
last_reviewed: 2026-09-22
-->
# Coin Change
[Problem Description](https://leetcode.com/problems/coin-change/description/)

Summary: Given an array of coin denominations `coins` and a target `amount`, return the fewest number of coins needed to make up that amount, assuming an unlimited supply of each denomination. Return `-1` if the amount cannot be made.

## Algorithm
Bottom-up DP over the target amount, with each state requiring a min over every coin denomination.
The `dp` array is sized `amount + 1` and initialized to a sentinel value representing "unreachable," since unlike there is no guarantee every amount is achievable.

## Recurrence
Let $\text{dp}(a)$ be the minimum number of coins needed to make amount $a$, for $0 \le a \le \text{amount}$.

```math
\text{dp}(a) = \begin{cases}
    0 & a = 0 \\
    \min\limits_{\substack{\text{coin} \,\in\, \text{coins} \\ \text{coin} \,\le\, a}} \big(1 + \text{dp}(a - \text{coin})\big) & a > 0
\end{cases}
```
**Base Case:** $\text{dp}(0) = 0$ (zero coins needed to make amount zero).

**Recursive Case:** The last coin placed in any optimal solution for amount $a$ was some denomination `coin` from `coins`. Removing that coin leaves an optimally solved subproblem for the remaining amount, $a - \text{coin}$, so that solution costs exactly $1 + \text{dp}(a - \text{coin})$. Since the identity of the last coin used isn't known in advance, every valid denomination is tried as a candidate, and the minimum across all candidates is taken.

**Final Answer:** The final answer is stored in $\text{dp}(\text{amount})$, or `-1` if it still holds the sentinel value.

## Complexity

Let `n = coins.length`. 

| Time | Space |
|---|---|
| `O(n * amount)`| `O(amount)` |

## Notes
- **Pseudo-polynomial time**: `O(n * amount)` is polynomial in the *value* of `amount`, not in the bit-length of its encoding (`O(log amount)`). Doubling the digit count of `amount` grows the runtime exponentially, so this is not polynomial time in the formal sense, even though the runtime expression looks polynomial.

