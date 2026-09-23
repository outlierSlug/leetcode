<!--
number: 0139
title: Word Break
pattern: dp-1d
difficulty: Medium
languages: Java
slug: word-break
last_reviewed: 2026-09-22
-->
# Word Break
[Problem Description](https://leetcode.com/problems/word-break/description/)

Summary: Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

## Algorithm
Let $\text{dp}(i)$ be true if the prefix `s[0, i)` (the first $i$ characters) can be fully segmented into dictionary words.

```math
\text{dp}(i) = \begin{cases}
    \text{true} & i = 0 \\
    \text{true} & \exists\, j \in [0, i) \text{ such that } \text{dp}(j) = \text{true} \text{ and } s[j, i) \in \text{wordDict} \\
    \text{false} & \text{otherwise}
\end{cases}
```

**Base Case:** $\text{dp}(0)$ is the empty prefix, zero characters, nothing to segment. This is vacuously true, the empty segmentation trivially succeeds, and it's what lets the recurrence bootstrap the very first word of `s`.

**Recursive Case:** for each prefix length $i$, check every possible earlier split point $j$. If some $j$ has $\text{dp}(j)$ true and the remaining substring `s[j, i)` is a dictionary word, then `s` up to $i$ is breakable by extending that earlier valid segmentation with one more word.

**Final Answer:** $\text{dp}(n)$, where $n = |s|$.

## Complexity

Let `n = |s| = s.length()` and `W` equal the total length of all words in `wordDict`.

| Time | Space |
|---|---|
| $O(n^3)$| $O(n + W)$ |

## Notes
- The nested loop runs $O(n^2)$ total iterations; each iteration's `substring` construction and `HashSet.contains` lookup cost up to $O(n)$, giving $O(n^3)$ overall.
- In Java, `new boolean[n + 1]` defaults every entry to `false`, so `dp[i]` never needs to be explicitly set false, only set true when a valid split is confirmed.
- Optimization worth knowing: this can be brought down to $O(n^2)$ by avoiding repeated substring construction, for example only checking $j$ values where $i - j$ matches the length of an actual dictionary word (bounding the inner loop by word lengths present), or using a Trie to check prefixes incrementally instead of rebuilding substrings from scratch each time.
