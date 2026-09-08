<!--
number: 0373
title: Find K Pairs with Smallest Sums
pattern: heap-priority-queue
difficulty: Medium
languages: Java
slug: find-k-pairs-with-smallest-sums
last_reviewed: 2026-09-07
-->
# Find K Pairs with Smallest Sums
[Problem Description](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/)

Summary: Given two sorted arrays `nums1` and `nums2` and an integer `k`, find the `k` pairs `(u, v)` (u from `nums1`, v from `nums2`) with the smallest sums.

## Algorithm
A naive approach might be to consider and sort all `m * n` pairs, but this is wasteful especially when `k` is small relative to the total number of pairs. Instead, we will use a min-heap to lazily explore only the candidate pairs that could plausibly matter.

### Intuition
Picture all possible pairs as a grid, with `nums1` indices as rows and `nums2` indices as columns. Because `nums2` is sorted, each individual row is itself a sorted list of sums (`nums1[i] + nums2[0], nums1[i] + nums2[1], ...` strictly increasing). This reframes the problem as: merge `m` sorted lists (the rows) and take the `k` smallest values overall, a classic use case for a heap-based k-way merge.

Rather than loading a full row into the heap, keep only the current "frontrunner" (smallest unproduced element) of each active row:
- Seed the heap with the first `min(m, k)` rows, each represented by its leftmost cell `(nums1[i], nums2[0], j=0)`. Capping at `k` rows is sufficient since the final answer can never contain more than `k` pairs, so no row beyond index `k-1` could ever be needed.
- Repeat `k` times: pop the globally smallest-sum entry (this is guaranteed correct, since the heap always holds each active row's true current minimum) and record it as an answer pair. Then push that *same row's next cell* (`j+1`), if it exists, advancing that row's frontier by one.

## Complexity

| Time | Space |
|---|---|
| `O(k log(min(m, k)))`| `O(min(m, k))` |

## Notes
- The heap never exceeds `min(m,k)` entries: it's seeded with that many, and each pop pushes at most one new entry back in.
- Each `int[]` heap entry stores `{nums1Value, nums2Value, nums2Index}`. The `nums1` index doesn't need to be stored since a given entry's row never changes; the `nums2` index does need to be stored (not just its value) since it's needed to look up the next cell, and can't be recovered from the value alone if `nums2` has duplicates.
- An alternative "frontier" approach exists: start at `(0,0)`, explore neighbors `(i+1,j)` and `(i,j+1)` with a visited set to avoid duplicate pushes. This is correct and generalizes to graph-search-style problems (e.g. Dijkstra), but requires extra visited-set bookkeeping this row-based approach avoids entirely by construction.
- Comparator overflow caution: summing two values near the problem's overflow bound can approach `Integer.MAX_VALUE`, and a *subtraction-based* comparator (`sum(a) - sum(b)`) adds further overflow risk on top of that. Safer alternatives: `Comparator.comparingInt` (or `.comparingLong`, casting to `long` before adding) compares sums directly rather than subtracting them, avoiding the second layer of risk; casting to `long` before the addition (not after) avoids the first.
