<!--
number: 0005
title: Longest Palindromic Substring
pattern: two-pointers
difficulty: Medium
languages: Java
slug: longest-palindromic-substring
last_reviewed: 2026-11-04
-->
# Longest Palindromic Substring
[Problem Description](https://leetcode.com/problems/longest-palindromic-substring/description/)

Summary: Given a string `s`, return the longest palindromic substring in `s`.

## Algorithm
Expand around every center.

A palindrome mirrors around its center, so instead of checking every substring from the outside, grow candidates outward from each possible center. There are two kinds of centers:
- **Odd length:** a single character, `expand(s, i, i)`.
- **Even length:** the gap between two adjacent characters, `expand(s, i, i + 1)`.

A string of length `n` has $2n - 1$ centers in total.

**`expand(s, left, right)`:** while both pointers are in bounds and `s[left] == s[right]`, move `left` back and `right` forward. Return the length of the last matching window, or 0 if an even center fails immediately.

**Main loop:** for each index `i`, take the longer of the odd and even expansions. If it beats the best length so far, record the length and the start index:

$$
\text{start} = i - \left\lfloor \frac{\text{len} - 1}{2} \right\rfloor
$$

This formula covers both parities. For an even palindrome, the floor accounts for the center sitting between `i` and `i + 1`. Finally, return the substring at the recorded start and length.

## Complexity

| Time | Space |
|---|---|
| $O(n^2)$ | $O(1)$ |

Each of the $2n - 1$ centers expands at most $O(n)$ steps.

## Notes
- **No pre-check for even centers:** if `s[i] != s[i + 1]`, the expansion stops immediately and returns 0, so no special case is needed. The bounds check runs before `charAt`, so `i + 1 == n` is safe.
- **Alternative solutions** include 2D DP and Manacher's Algorithm.