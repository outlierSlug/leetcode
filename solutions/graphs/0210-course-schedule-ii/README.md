<!--
number: 0210
title: Course Schedule II
pattern: graphs
difficulty: Medium
languages: Java
slug: course-schedule-ii
last_reviewed: 2026-09-19
-->
# Course Schedule II
[Problem Description](https://leetcode.com/problems/course-schedule-ii/description/)

Summary: Given `numCourses` and prerequisite pairs, return one valid course ordering respecting all prerequisites, or `[]` if impossible (a cycle exists). Any valid topological sort may be returned if it exists.

## Algorithm
Direct extension of [Course Schedule](../0207-course-schedule/)'s cycle-detection DFS, with topological sort added almost for free: append each course to `order` right when it's marked `state = 2` ("done", i.e. all its dependencies fully processed), then **reverse** the whole list at the end.

Why does this produce a valid order? A node is only marked done after every course it depends on has already been marked done, so nodes get appended in the order "nothing left unprocessed depending on it" , which is the reverse of the desired dependencies-first order. Reversing at the end corrects this.

If a cycle is detected anywhere, return an empty array immediately - no valid ordering exists.

## Complexity

| Time | Space |
|---|---|
| `O(V + E)`| `O(V + E)` |

## Notes
- `List<Integer>` to `int[]` conversion (no built-in direct cast): either a manual loop copying each element, or `order.stream().mapToInt(Integer::intValue).toArray()`.
- Identical asymptotic bound to Course Schedule. The `order` list additions, final reversal, and `List`-to-array conversion are each `O(V)`, all absorbed into the already-dominant `O(V + E)` term.