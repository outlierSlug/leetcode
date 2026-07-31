<!--
number: 0290
title: Word Pattern
pattern: arrays-hashing
difficulty: Easy
languages: Java
slug: word-pattern
last_reviewed: 2026-07-25
-->
# Word Pattern
[Problem Description](https://leetcode.com/problems/word-pattern/description/)

Summary: Given a `pattern` of characters and a string `s` of words, find if `s` follows the same pattern. That is, each letter in `pattern` is mapped to exactly one unique word in `s`, and each unique word in `s` maps to exactly one letter in `pattern`.

## Algorithm
We will use a hashmap to map characters in `pattern` to words in `s`, and use a set to track the used words so far. First, we check to make sure the number of characters in `pattern` is equal to the number of words in `s`. Then, we iterate through each character-word pair, and check for the following:

1. If `charMap` contains the character already, check to make sure its mapped word is equal to the current `word`. If not, return `false`.
2. Otherwise, the character is new. We will add it to the map, but first, we have to check to make sure the current `word` is unused. If it is already used (meaning it is already mapped to a different character) then we return `false`. If not, then we add the mapping to `charMap` and the current word to `usedWords`.
3. Return true if the strings pass all checks.

## Complexity

Let `n` be the length of `s` and `m` be the length of `pattern`.

| Approach | Time | Space |
|---|---|---|
| HashMap + HashSet | `O(n + m)` | `O(n + m)` |

Splitting `s` into words takes `O(n)` time, as we must traverse every character in `s` and split on the spaces. The for loop runs `m` times, yielding an overall linear time complexity.

The `words` array takes up `O(n)` space, as we store every word in `s`, and `charMap` will store at most `m` unique characters as keys, yielding a space complexity of `O(m)`. `usedWords` will also include at most `n` words (if all words in `s` are unique). Thus, the overall space complexity is linear.

## Notes
Changing `split(" ")` to `split("\\+")` can handle edge cases with multiple whitespaces and tabs.