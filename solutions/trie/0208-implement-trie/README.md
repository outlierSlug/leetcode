<!--
number: 0208
title: Implement Trie (Prefix Tree)
pattern: trie
difficulty: Medium
languages: Java
slug: implement-trie-prefix-tree
last_reviewed: 2026-11-02
-->
# Implement Trie (Prefix Tree)
[Problem Description](https://leetcode.com/problems/implement-trie-prefix-tree/description/)

Summary: Implement a trie that supports `insert(word)`, `search(word)` (whether the exact word was inserted), and `startsWith(prefix)` (whether any inserted word begins with the prefix). All inputs consist of lowercase English letters.

## Algorithm
A tree where each edge represents a character and each word is a path from the root.

**Node structure:**
- `children`: a `TrieNode[26]` array, where `children[c - 'a']` is the child for character `c`, or `null` if no inserted word continues with `c` at this point. The character is implied by the slot index, so it is never stored.
- `isEnd`: whether an inserted word ends at this node. This flag distinguishes a full word from a prefix of a longer word, for example `"app"` inside `"apple"`.

The root represents the empty prefix.

**Operations:**
- `insert(word)`: walk from the root one character at a time. If the child for the next character is `null`, create it, then step into it. After the last character, set `isEnd = true` on the current node.
- **Shared walk:** follow the path for a string from the root, failing as soon as a child is missing.
- `search(word)`: the walk must succeed **and** end on a node with `isEnd` set.
- `startsWith(prefix)`: the walk only needs to succeed.

Words with a common prefix share the nodes of that prefix, so inserting `"app"` after `"apple"` creates no new nodes and only sets a flag.

## Complexity
Let `L` be the length of the input string and `N` the total number of nodes in the trie.

| Operation | Time | Space |
|---|---|---|
| `insert` | $O(L)$ | $O(L)$ new nodes at most |
| `search` | $O(L)$ | $O(1)$ |
| `startsWith` | $O(L)$ | $O(1)$ |

Total storage is $O(26N)$, where `N` is at most the total number of characters inserted.

## Notes
- **Array vs. map children:** a `TrieNode[26]` array gives direct indexing but reserves 26 slots per node. For a large or unknown alphabet, use `Map<Character, TrieNode>`, where `computeIfAbsent(c, k -> new TrieNode())` combines insert's check-and-create into one call. The traversal logic is unchanged.
