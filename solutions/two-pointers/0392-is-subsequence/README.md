<!--
number: 0392
title: Is Subsequence
pattern: two-pointers
difficulty: Easy
languages: Java
slug: is-subsequence
last_reviewed: 2026-07-24
-->
# Is Subsequence
[Problem Description](https://leetcode.com/problems/is-subsequence/description/)

Summary: Given two strings `s` and `t`, return `true` if `s` is a *subsequence* of `t`, or `false` otherwise.

## Algorithm
We will use two pointers, `sPointer` and `tPointer`, that initially point at the first character in `s` and `t`, respectively. Then, we will continuously do the following until we reach the end of either string:

1. If `s.charAt(sPointer) == t.charAt(tPointer)`, we have found the current subsequence character, so we increment `sPointer` to the next subsequence character to find.
2. We always increment `tPointer`, so we move forward to check each letter for the next subsequence character.
3. If we end up finding all the characters of `s` as a subsequence in `t`, then `sPointer` will have reached the end of `s`, and we will end up returning `true`. Otherwise, `sPointer` will not have reached the end of `s` and we will return false.

## Complexity
Let `n = t.length()`.

| Approach | Time | Space|
|---|---|---|
| Two Pointers | `O(n)` | `O(1)` |

## Notes
* If this function were to be called repeatedly on many incoming `s` strings against the same fixed `t`, it would be more efficient to preprocess `t` into a table, mapping each position and character to the next occurrence of that character, allowing each subsequent query to run faster.