<!--
number: 0211
title: Design Add and Search Words Data Structure
pattern: trie
difficulty: Medium
languages: Java
slug: design-add-and-search-words-data-structure
last_reviewed: 2026-11-03
-->
# Design Add and Search Words Data Structure
[Problem Description](https://leetcode.com/problems/design-add-and-search-words-data-structure/description/)

Summary: Design a data structure that supports `addWord(word)` and `search(word)`, where `search` returns whether any added word matches. The search string may contain `.`, which matches any single letter. All words consist of lowercase English letters.

## Algorithm
A trie, with search implemented as a DFS to handle wildcards.

**`addWord(word)`:** identical to `insert` in [208](../0208-implement-trie/). Walk from the root, creating missing children, and set `isEnd = true` on the final node.

**`search(word)`:** in a plain trie, each character leads to at most one child. A `.` can continue through any existing child, so the search branches and becomes a DFS. The helper `dfs(word, i, node)` returns whether `word[i..]` can be matched starting from `node`:
- **Base case:** if `i == word.length()`, the whole word has been matched, so return `node.isEnd`.
- **Wildcard (`.`):** for each non-null child, recurse with `i + 1`. Return `true` as soon as any branch succeeds; return `false` if none do.
- **Regular letter:** if its child is `null`, return `false`. Otherwise, recurse into that child with `i + 1`.

`search` calls `dfs(word, 0, root)`.

## Complexity
Let `L` be the length of the word, `d` the number of `.` characters in a search, and `N` the number of nodes in the trie.

| Operation | Time | Space |
|---|---|---|
| `addWord` | $O(L)$ | $O(L)$ new nodes at most |
| `search` (no wildcards) | $O(L)$ | $O(L)$ recursion |
| `search` (with wildcards) | $O(\min(26^d \cdot L,\ N))$ | $O(L)$ recursion |

Each `.` can branch up to 26 ways, but a single search visits each trie node at most once, so the cost is also bounded by `N`. The problem limits searches to at most 2 wildcards.

## Notes
- **Short-circuiting:** returning `true` on the first successful branch avoids exploring the rest of the trie once a match is found.
- **`isEnd` in the base case:** reaching the end of the search string only counts as a match if a word ends at that node, the same distinction as `search` vs. `startsWith` in 208.
- **Static nested class:** `TrieNode` should be `static`. A non-static inner class stores a hidden reference to the enclosing `WordDictionary` in every node, wasting memory.
