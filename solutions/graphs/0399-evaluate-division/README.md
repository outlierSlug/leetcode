<!--
number: 0399
title: Evaluate Division
pattern: graphs
difficulty: Medium
languages: Java
slug: evaluate-division
last_reviewed: 2026-09-19
-->
# Evaluate Division
[Problem Description](https://leetcode.com/problems/evaluate-division/description/)

Summary: Given equations like `a/b = 2.0`, `b/c = 3.0` and queries like `a/c`, compute each query's value using the given equations, returning `-1.0` when it can't be determined.

## Algorithm
This problem can be transformed into a graph problem via the following construction and traversal algorithm:

Let the vertices be unique variables. Each equation `a/b = w` becomes two directed, weighted edges: `a -> b` with weight `w`, and `b -> a` with weight `1/w`. Adding both directions during construction is what lets a single graph answer queries in either direction without extra handling.

We declare a custom `record`:

```java
record Edge(String node, double weight) {}
```
which bundles a neighbor and its edge weight; `Map<String, List<Edge>>` is the weighted adjacency list.

Answering a query `a/c` means finding any path from `a` to `c` and multiplying edge weights along the way: if `a/b = w1` and `b/c = w2`, substituting gives `a/c = w1*w2`. Each DFS step performs one substitution, and the running `product` parameter tracks the cumulative ratio.

- **Base case:** `current.equals(target)`, return the accumulated `product`.
- **Recursive case:** for each unvisited neighbor edge, recurse with `product * neighbor.weight()`. Only return early on a *successful* branch (result `!= -1.0`); a failed branch must not short-circuit the whole search, since other neighbors may still lead to the target.
- **No path found:** after exhausting all neighbors without success, return `-1.0`, which is the sentinel for "not reachable." Comparing `-1.0` with `!=` is safe here despite usual floating-point caution, since it's a deliberately-returned exact literal, never a computed value that could merely be close to it.
- Before running DFS, if either query variable *never appeared in any equation*, return `-1.0` immediately without searching.


## Complexity
- Let `Q` be the number of queries, i.e. `Q = queries.size()`. 

- Let `V` be the number of vertices constructed by the graph, i.e. the number of unique variables defined by `equations`. 

- Let `E` be the the number of edges constructed by the graph, i.e. `E = 2 * equations.size()`, since each equation creates two bidirectional edges.

| Time | Space |
|---|---|
| `O(Q * (V + E))`| `O(V + E)` |

Each query runs DFS, which in the worst-case visited every node and edge once, so a single query costs `O(V + E)`. For `Q` queries overall, the runtime is thus dominated by `O(Q * (V + E))`. 

The graph itself dominates space complexity, which is `O(V + E)` for adjacency lists across all nodes.

## Notes
- [Neetcode Solution](https://www.youtube.com/watch?v=Uei1fwDoyKk)
