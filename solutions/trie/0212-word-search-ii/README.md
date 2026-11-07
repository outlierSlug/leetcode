<!--
number: 0212
title: Word Search II
pattern: trie
difficulty: Hard
languages: Java
slug: word-search-ii
last_reviewed: 2026-11-06
-->
# Word Search II
[Problem Description](https://leetcode.com/problems/word-search-ii/description/)

Summary: Given an `m x n` grid of characters `board` and a list of strings `words`, return all words found on the board. Each word must be built from letters of sequentially adjacent cells (horizontal or vertical neighbors), and the same cell may not be used more than once in a word.

## Algorithm
Running [Word Search](../../backtracking/0079-word-search/) once per word repeats work, since words that share a prefix get re-traced from the same cells. Instead, insert every word into a trie and run one backtracking DFS from each cell that walks the board and the trie together.
 
**`buildTrie(words)`:** identical to `insert` in [208](../0208-implement-trie/), except the end node stores the word itself (`String word`) instead of `isEnd`. A found word can then be added directly without rebuilding the path.
 
**`dfs(board, row, col, parent)`:** `parent` is the trie node *before* consuming `board[row][col]`, so `findWords` calls it with `root` from every cell.
- **Prune:** return if the cell is out of bounds, already on the current path (`'#'`), or `parent` has no child for its character. No word continues down this path.
- **Found:** step into the child `node`. If `node.word != null`, add it to the result and set it to `null` so it can't be added again from another path.
- **Choose / explore / un-choose:** mark the cell `'#'`, recurse in all 4 directions with `node`, then restore the original character.
Keep going after a word is found, since it may be a prefix of another word (`"oa"` → `"oat"`).

## Complexity
Let `S` be the total number of characters across `words` and `L` the length of the longest word.
 
| Time | Space |
|---|---|
| $O(S + m \cdot n \cdot 4 \cdot 3^{L-1})$ | $O(S + L)$ |
 
Building the trie is $O(S)$. Each DFS path is at most `L` deep because the trie has no deeper nodes, with 4 choices on the first step and at most 3 after. Space is the trie plus the recursion stack.

## Notes
- **Storing the word in the node:** avoids carrying a `StringBuilder` through the DFS and appending/deleting at each step.
- **Duplicates without a `Set`:** nulling `node.word` after adding it guarantees each word is reported at most once, even if it can be traced from several starting cells.
- **`'#'` sentinel:** marks cells on the current path, not just the current word, since one path can complete several words. The explicit `'#'` check is required: `'#' - 'a'` is negative, so indexing `children` with it throws `ArrayIndexOutOfBoundsException`. A `boolean[][] visited` avoids mutating the input at the cost of $O(m \cdot n)$ extra space.