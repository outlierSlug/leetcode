<!--
number: 0076
title: Minimum Window Substring
pattern: sliding-window
difficulty: Hard
languages: Java
slug: minimum-window-substring
last_reviewed: 2026-10-31
-->
# Minimum Window Substring
[Problem Description](https://leetcode.com/problems/minimum-window-substring/description/)

Summary: Given strings `s` and `t`, return the minimum window substring of `s` such that every character in `t`, including duplicates, is included in the window. If no such substring exists, return `""`.

## Algorithm
Variable-size sliding window: expand until the window is valid, then shrink while it stays valid.

**Setup:**
- `tMap`: the required count of each character in `t`.
- `window`: counts of `t`'s characters inside the current window.
- `need`: the number of **distinct** characters in `t` (`tMap.size()`).
- `have`: the number of distinct characters whose *required count is currently met*. The window is valid exactly when `have == need`, which turns an $O(|\Sigma|)$ map comparison into an $O(1)$ check.

**Main loop**, for each `right`:
1. **Expand:** if `s[right]` is in `tMap`, increment its window count. If the count now **equals** its required count, increment `have`.
2. **Shrink** while `have == need`:
   - Record the window if `right - left + 1` is the shortest so far, saving its start index and length.
   - Remove `s[left]`: if it is in `tMap`, decrement its window count. If the count drops **below** its required count, decrement `have`.
   - Advance `left`.

Finally, return `""` if no window was recorded, otherwise the substring at the saved start index and length.

## Complexity
Let `k` be the number of distinct characters in `t`.

| Time | Space |
|---|---|
| $O(\lvert s \rvert + \lvert t \rvert)$ | $O(k)$ |

Each index enters the window once through `right` and leaves at most once through `left`, with $O(1)$ work per step.

## Notes
- **Threshold updates:** `have` changes only when a character's count crosses its requirement. On adding, the check is `==` rather than `>=`, so extra copies beyond the requirement don't increment `have` again. On removing, the check is `<`, so `have` drops only at the moment a character stops being satisfied.
- **Zero counts are harmless:** decremented entries stay in `window` with count 0, which behaves the same as a missing key for every check here.
- **`Integer` comparisons:** the add step uses `.equals` because `==` on two `Integer` objects compares references, which fails for values above 127. Relational operators like `<` unbox to `int` and are safe.
- **Record indices, not substrings:** building a substring for every candidate costs $O(n)$ each. Saving the start and length and slicing once at the end keeps the loop $O(1)$ per step.
- **Contrast with 3 (Longest Substring Without Repeating Characters):** 3 maximizes, so it shrinks only when the window becomes invalid. This problem minimizes, so it shrinks as long as the window remains valid.
