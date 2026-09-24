<!--
number: 0347
title: Top K Frequent Elements
pattern: heap-priority-queue
difficulty: Medium
languages: Java
slug: top-k-frequent-elements
last_reviewed: 2026-09-23
-->
# Top K Frequent Elements
[Problem Description](https://leetcode.com/problems/top-k-frequent-elements/description/)

Summary: Given an integer array `nums` and an integer `k`, return the `k` most frequent elements, in any order.

## Algorithm
Two stages: build a frequency map, then use a min-heap capped at size `k` to find the top `k` frequencies without a full sort.

**Stage 1**: count occurrences of each distinct value with a `HashMap<Integer, Integer>`.

**Stage 2**: maintain a min-heap of `(value, frequency)` pairs, ordered by frequency. Push every entry from the frequency map onto the heap, and whenever the heap's size exceeds `k`, evict the entry with the smallest frequency. By the end, the heap holds exactly the `k` largest-frequency entries.

## Complexity

Let `n = nums.length` and `d` = number of distinct values (`d <= n`).

| Time | Space |
|---|---|
| $O(n + d \log k)$ | $O(n)$ |

Building the frequency map is `O(n)`. Each of the `d` heap operations costs `O(log k)`, since the heap never grows past size `k`. In the worst case `d` approaches `n`, so this is often quoted as `O(n log k)`. Space is dominated by the frequency map, `O(n)` in the worst case of all-distinct values (the heap itself only ever holds `O(k)`).

## Notes
- `map.put(num, map.getOrDefault(num, 0) + 1)` collapses the add-to-map lines and is functionally identical.
