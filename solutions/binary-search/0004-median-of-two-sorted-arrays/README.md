<!--
number: 0004
title: Median of Two Sorted Arrays
pattern: binary-search
difficulty: Hard
languages: Java
slug: median-of-two-sorted-arrays
last_reviewed: 2026-09-04
-->
# Median of Two Sorted Arrays
[Problem Description](https://leetcode.com/problems/median-of-two-sorted-arrays/description/)

Summary: Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the **median** of the two sorted arrays.

## Algorithm
A naive approach might involve merging both arrays, but that would take `O(m+n)` time. Instead, we can binary search over a **partition point**, not over values: find a way to split both arrays such that the combined "left" elements and combined "right" elements form a valid sorted split, without ever merging. We construct the algorithm as follows:

- Always binary search over the **smaller** array (swap arguments if `nums1` is larger), bounding the search to `O(log(min(m,n)))`.
- For a candidate partition `i` in `nums1` (`i` elements go left, `m-i` go right), the corresponding partition `j` in `nums2` is forced: `j = (m+n+1)/2 - i`, so the combined left side always has the correct total size. Using `(m+n+1)/2` (integer division) sends any "extra" element from an odd total length to the left side.
- Boundary elements straddle each cut: `nums1Left = nums1[i-1]`, `nums1Right = nums1[i]`, similarly for `nums2`. Sentinels stand in when a cut sits at an array's edge, so there's no real constraint to violate on that side.
- A partition is **valid** when `nums1Left <= nums2Right && nums2Left <= nums1Right`, meaning everything on one array's left part is less than or equal to everything on the other array's right part, i.e. the combined split is properly ordered.
- If `nums1Left > nums2Right`, `i` reaches too far into large values, so we shrink it (`hi = i - 1`). If `nums2Left > nums1Right`, `i` is too small, so we widen it (`lo = i + 1`).
- Once valid: for **even** total length, median is `(max(nums1Left, nums2Left) + min(nums1Right, nums2Right)) / 2.0`. For **odd** total length, the left side has one extra element by construction, so its maximum alone is the median: `max(nums1Left, nums2Left)`.

## Complexity

| Time | Space |
|---|---|
| `O(log(min(m ,n)))`| `O(1)` |

## Notes
- [Neetcode Solution](https://www.youtube.com/watch?v=q6IEA26hvXc)
- `nums1[i]` is always the first element of `nums1`'s *right* part.
- Sentinel values (`Integer.MIN_VALUE`/`MAX_VALUE`) let the validity check apply uniformly even when a cut sits at an array's edge (no real element to compare there).
