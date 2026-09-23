<!--
number: 0049
title: Group Anagrams
pattern: arrays-hashing
difficulty: Medium
languages: Java
slug: group-anagrams
last_reviewed: 2026-09-23
-->
# Group Anagrams
[Problem Description](https://leetcode.com/problems/group-anagrams/description/)

Summary: Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

## Algorithm
We will use a map where keys `strKey` are sorted canonical forms of the `str` which are their values in a list. For every string in `strs`, we first take its letters and sort them, and with that sorted canonical key, we add that string to the values of that key in the map.

Return a list of `map.values()` which contains all anagrams groups together.

## Complexity

Let `n = strs.length` and `k = str.length()`.

| Time | Space |
|---|---|
| $O(n \cdot k\log k)$ | $O(nk)$ |

We process all `n` strings, and each iteration is dominated by the sorting runtime which is $k \log k$.

## Notes
- `String strKey = new String(strArray)` is the standard and efficient way to create a string back from a `char[]`.
