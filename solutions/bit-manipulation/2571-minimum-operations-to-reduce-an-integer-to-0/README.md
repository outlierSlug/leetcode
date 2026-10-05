<!--
number: 2571
title: Minimum Operations to Reduce an Integer to 0
pattern: bit-manipulation
difficulty: Medium
languages: Java
slug: minimum-operations-to-reduce-an-integer-to-0
last_reviewed: 2026-10-04
-->
# Minimum Operations to Reduce an Integer to 0
[Problem Description](https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/description/)

Summary: Given a positive integer `n`, one operation adds or subtracts any power of 2. Return the minimum number of operations needed to reduce `n` to 0.

## Algorithm
Greedy pass, processing `n`'s binary digits from the lowest bit up. Each operation adds or subtracts a single power of 2, so the question is how to clear all the 1 bits as cheaply as possible.

While `n > 0`:
- **Lowest bit is 0** (`(n & 1) == 0`): nothing to clear at this position, so shift right (`n >>= 1`). This costs nothing: any sequence of operations that reduces `n / 2` to 0 works for `n` with every power of 2 doubled.
- **Lowest two bits are `11`** (`(n & 3) == 3`): a run of at least two 1s. Add 1, which carries through the run, turning it into 0s with a single 1 just above it. That costs 1 operation now and 1 later, instead of 1 per bit in the run.
- **Lowest two bits are `01`**: a lone 1. Subtract 1 to clear it with one operation.

## Complexity

| Time | Space |
|---|---|
| $O(\log n)$ | $O(1)$ |

Every add or subtract leaves `n` even, so the next step is a shift. Adding 1 can lengthen `n` by at most one bit, so the loop runs $O(\log n)$ times.

## Notes
- **`n & 3`:** `3` is `11` in binary, so `n & 3` keeps only the last two bits. `(n & 3) == 3` means both are 1.
- **Why a run of 1s should be rounded up:** clearing a run of $k$ ones one at a time takes $k$ operations. Adding 1 turns the run into a single 1 one position higher (for example, `0111 + 1 = 1000`), which takes 2 operations in total. For $k = 2$ it's a tie, and for $k \ge 3$ it's strictly better.