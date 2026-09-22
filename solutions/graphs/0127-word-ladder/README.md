<!--
number: 0127
title: Word Ladder
pattern: graphs
difficulty: Hard
languages: Java
slug: word-ladder
last_reviewed: 2026-09-22
-->
# Word Ladder
[Problem Description](https://leetcode.com/problems/word-ladder/description/)

Summary: Given `beginWord`, `endWord`, and a `wordList`, return the length of the *shortest transformation sequence* from `beginWord` to `endWord` (counting both endpoints), where each step changes exactly one letter and every intermediate word must be in `wordList`. Return `0` if impossible.

## Algorithm
Structurally identical to [Minimum Genetic Mutation](../0433-minimum-genetic-mutation/): BFS with "try every single-character substitution at every position" neighbor generation.

Since the answer is "number of words in the sequence" (not "number of transformations"), the level counter starts at `1` (representing `beginWord` itself as the first word), not `0`.

## Complexity

Let `W = wordList.size()` and `L = beginWord.length()`.

| Time | Space |
|---|---|
| `O(W * L^2)`| `O(W * L)` |

## Notes
- At most `W` words are ever enqueued; each dequeue tries `25L` candidates, each costing `O(L)` to build and hash/compare, giving `O(L^2)` per dequeue and `O(W * L^2)` overall.
