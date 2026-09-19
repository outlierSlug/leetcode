<!--
number: 0133
title: Clone Graph
pattern: graphs
difficulty: Medium
languages: Java
slug: clone-graph
last_reviewed: 2026-09-19
-->
# Clone Graph
[Problem Description](https://leetcode.com/problems/clone-graph/description/)

Summary: Given a reference to a node in a connected undirected graph, return a deep copy of the entire graph.

## Algorithm
We will use a map to keep track of cloned nodes (original node -> cloned node) and recursively create and return a deep copy of the graph.

- If the current node is already cloned, return the existing clone immediately.
- Otherwise, create the clone and **register it in `visited` before recursing into neighbors**. This ordering is what makes cycles safe. Without it, a cycle back to a node still "in progress" would trigger cloning that node again from scratch, causing infinite recursion.
- The `return clone` at the end of each call hands the just-created clone back to whichever call is iterating over it as a neighbor. `clone.neighbors.add(dfs(neighbor, visited))` is what reconstructs each edge in the copy, one connection at a time as the recursion unwinds. For the single outermost call (from `cloneGraph`), this same return value becomes the final answer.

## Complexity

| Time | Space |
|---|---|
| `O(V + E)`| `O(V)` |

## Notes
- `V`/`E` (vertices/edges) is the standard complexity form for explicit graph traversal problems.
- Every node is cloned exactly once; revisits are caught by the map and return in `O(1)`. Total edge traversal across all nodes' neighbor lists is `O(E)`.