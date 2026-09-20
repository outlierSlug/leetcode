<!--
number: 0207
title: Course Schedule
pattern: graphs
difficulty: Medium
languages: Java
slug: course-schedule
last_reviewed: 2026-09-19
-->
# Course Schedule
[Problem Description](https://leetcode.com/problems/course-schedule/description/)

Summary: Given `numCourses` and prerequisite pairs `[a, b]` (a requires b), determine if it's possible to finish all courses. It is impossible if the dependency graph contains a cycle.

## Algorithm
We will set up a directed graph where an edge from `a -> b` means that `a` is a prerequisite of `b`. We will run a cycle detection algorithm using a 3-state scheme as follows:

`0 = unvisited`, `1 = visiting` (on the current DFS path), `2 = done` (fully explored, confirmed safe). Encountering a neighbor in state `1` specifically signals a cycle, since that node is an ancestor on the *current* path.

- Every course gets an adjacency-list entry (even an empty one, via `putIfAbsent`) so `graph.get(course)` is never `null`.
- The neighbor loop only returns early on `true` (cycle found); a `false` result from one neighbor must not short-circuit the search of the remaining neighbors.
- `state[course] = 2` is only set after the full neighbor loop completes, so a node is marked "done" only once every descendant has been fully explored.
- DFS is attempted from every course (outer loop), to handle disconnected components, but a node already marked `2` (done) is skipped in O(1), and a node is only ever fully explored once across the whole algorithm.

## Complexity
Let `V = numCourses` and `E = prerequisites.length`.

| Time | Space |
|---|---|
| `O(V + E)`| `O(V + E)` |

## Notes
- Despite looping over every course as a DFS starting point, this does **not** multiply into `O(V*(V+E))`: the `state` array is shared and persists across all outer-loop iterations (a node marked done stays done), so each node is fully explored exactly once and each edge examined exactly once, total.
