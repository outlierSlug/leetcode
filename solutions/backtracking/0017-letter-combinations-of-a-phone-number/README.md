<!--
number: 0017
title: Letter Combinations of a Phone Number
pattern: backtracking
difficulty: Medium
languages: Java
slug: letter-combinations-of-a-phone-number
last_reviewed: 2026-09-08
-->
# Letter Combinations of a Phone Number
[Problem Description](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)

Summary: Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent

## Algorithm
We will use the classic backtracking template: choose, explore, un-choose.

We will build combinations one character at a time via recursion. At each call, `index` tracks which digit of the input is being processed:
- **Base case:** when `index` reaches the length of `digits`, `current` holds one complete combination. Add a copy of it to `result` and return, without trying further letters at this position.
- **Recursive case:** look up the letters mapped to the current digit. For each letter: append it to `current` (choose), recurse to the next digit `index + 1` (explore), then remove the just-appended letter from `current` (un-choose/backtrack) before trying the next letter option.

Un-choosing is what allows the same `StringBuilder` to be reused across all branches of the recursion tree, rather than needing a fresh copy at every level.

## Complexity

| Time | Space |
|---|---|
| `O(n * 4^n)`| `O(n)` |

## Notes
- Worst case combination count is `4^n` (digits `7` and `9` each map to 4 letters); actual count ranges between `3^n` and `4^n` depending on the input digits. Each combination costs `O(n)` to materialize via `current.toString()`, giving `O(n * 4^n)` total time.
- Auxiliary space is `O(n)`: the `StringBuilder` holds at most `n` characters at any point, and recursion depth is at most `n` (one call per digit). The `result` list itself holds `O(n * 4^n)` characters total across all combinations, but that's required output, not extra algorithmic overhead.
- The un-choose step must remove from the *end of `current`* (`current.length() - 1`), not use the recursion's `index` variable directly - `index` tracks position within the input `digits`, not position within the string being built in `current`; the two only coincide by construction, not by meaning.
- Digit-to-letters mapping can also be done via a `String[]` array indexed by `digit - '2'` instead of a `HashMap<Character, String>` — avoids hashing overhead, since the digit range is small, fixed, and contiguous.
