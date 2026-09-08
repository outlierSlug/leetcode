<!--
number: 0502
title: IPO
pattern: heap-priority-queue
difficulty: Hard
languages: Java
slug: ipo
last_reviewed: 2026-09-07
-->
# IPO
[Problem Description](https://leetcode.com/problems/ipo/description/)

Summary: Given initial capital `w` and `n` total projects, each requiring a minimum capital to start and yielding a profit on completion, choose at most `k` projects (one at a time) to maximize final capital.

## Algorithm
We will maintain both a minHeap and a maxHeap, and make the greedy choice to always choose the next affordable project with the largest profit.

- `minCapitalHeap`: all not-yet-started projects, ordered by capital requirement. Its top is always the cheapest project to unlock.
- `maxProfitHeap`: projects confirmed affordable so far, ordered by profit. Its top is always the best choice among what's currently reachable.

At each step up to `k` total projects:
1. Migrate every project from `minCapitalHeap` into `maxProfitHeap` whose capital requirement is `<= w`, i.e. it is currently affordable.
2. If `maxProfitHeap` is empty, no project is reachable; stop early.
3. Otherwise, pop the highest-profit project and add its profit to `w`.

## Complexity

| Time | Space |
|---|---|
| `O((n + k) log n)`| `O(n)` |

## Notes
- Time breaks into two parts: building `minCapitalHeap` and migrating projects both happen `O(n)` times total across the *whole* algorithm (each project migrates at most once, ever, even though the migration loop is nested inside the k-iteration loop) at `O(log n)` each, giving `O(n log n)`. Separately, each of the `k` iterations does one `poll()` from `maxProfitHeap` at `O(log n)`, giving `O(k log n)`. Combined: `O((n + k) log n)`.
- Since `k <= n` is typical (you can complete at most `n` projects total), this is often simplified to `O(n log n)`, but the more precise bound accounts for `k` separately.
- Space is `O(n)` since every project lives in exactly one of the two heaps at any given time, combined size never exceeding `n`.
- Greedy works here specifically because capital is a threshold to unlock a project, not a cost consumed by it. Contrast with problems like 0/1 Knapsack, where resources are actually spent by each choice; there, greedy fails and a different approach (DP) is required.
- Guard against an empty `maxProfitHeap` before polling: if `k` exceeds the number of projects ever reachable, later iterations would otherwise call `.poll()` on an empty heap and crash on the subsequent `[0]` access on a `null` result.