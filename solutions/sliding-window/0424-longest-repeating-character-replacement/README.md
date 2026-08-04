<!--
number: 0424
title: Longest Repeating Character Replacement
pattern: sliding-window
difficulty: Medium
languages: Java
slug: longest-repeating-character-replacement
last_reviewed: 2026-08-04
-->
# Longest Repeating Character Replacement
[Problem Description](https://leetcode.com/problems/longest-repeating-character-replacement/description/)

Summary: You are given a string `s` and an integer `k`. You can take any character of the string and change it to any other uppercase English letter, and you can perform this operation at most `k` times. Return the length of the longest substring containing all the same letter after performing such operations.

## Algorithm
We will use a variable-length sliding window and perform a single pass through the string. The window `[left, right]` is valid when `(right - left + 1) - maxFreq <= k`, i.e. the number of characters that would need replacing to make the window uniform does not exceed `k`. 

The key optimization in the algorithm is that `maxFreq` is tracked as a running maximum and is never decrement, even if the window shrinks. This is safe because:
- The window length is monotonically non-decreasing, and either remains the same or increases by 1 every iteration.
- A stale `maxFreq` can only cause the algorithm to shrink the window *more conservatively* than strictly necessary.
- `maxFreq` acts as a watermark representing the "best density ever proven for a window this size", not a live measurement, so it does not need recomputation on shrink.

The algorithm performs the following steps:
1. Expand `right` and increment the frequency count for `s.charAt(right)`.
2. Update `maxFreq`, which is the max of the current `maxFreq` and the count of the character we just incremented in step 1
3. Shrink the window if necessary to make it valid by incrementing the `left` pointer and update the frequency counts accordingly
4. Update `result`, which is the max of the current `result` and the current size of the window.

## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(1)` |

There are at most 26 keys in the map (uppercase English letters), yielding a constant space compleixty.

## Notes
- **HashMap vs. Array**: We are guaranteed uppercase English letters only, so `int[26]` indexed by `c - 'A'` would work identically with a better constant factor (no hashing, no boxing/ unboxing of `Character`/`Integer`, no `getOrDefault` overhead). HashMap is more general (works for arbitrary character sets) but is not the leanest choice for this specific problem.
- Map entries are never deleted even when a character's count drops to 0 (e.g. fully leaves the window). This is harmless given the bounded 26-key space, but would be worth cleaning up if the key space were unbounded.

