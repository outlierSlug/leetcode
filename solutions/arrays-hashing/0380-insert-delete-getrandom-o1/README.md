<!--
number: 0380
title: Insert Delete GetRandom O(1)
pattern: arrays-hashing
difficulty: Medium
languages: Java
slug: insert-delete-getrandom-o1
last_reviewed: 2026-11-04
-->
# Insert Delete GetRandom O(1)
[Problem Description](https://leetcode.com/problems/insert-delete-getrandom-o1/description/)

Summary: Implement a `RandomizedSet` that supports `insert(val)` and `remove(val)`, each returning whether the set changed, and `getRandom()`, which returns a random element with every element equally likely. All operations must run in average $O(1)$ time.

## Algorithm
A hashmap combined with an array list.

Neither structure works alone. A `HashSet` supports $O(1)$ insert and remove but has no indices, so picking a uniformly random element is not $O(1)$. An `ArrayList` supports $O(1)$ random access, but removing from the middle shifts later elements in $O(n)$. Together:
- `list` stores the elements in arbitrary order, enabling random access.
- `map` stores each value's index in `list`, enabling $O(1)$ lookup.

**Operations:**
- `insert(val)`: if `val` is already in `map`, return `false`. Otherwise, append it to `list`, record its index (`list.size() - 1`) in `map`, and return `true`.
- `remove(val)`: if `val` is not in `map`, return `false`. Otherwise:
  1. Look up `idx`, the index of `val`, and `lastVal`, the last element of `list`.
  2. Overwrite `list[idx]` with `lastVal`, then remove the last slot of `list`.
  3. Update `map` so `lastVal` points to `idx`, then remove `val` from `map`.
  4. Return `true`.
- `getRandom()`: return `list[rand.nextInt(list.size())]`.

The swap turns a removal from the middle into a removal from the end. Because a set has no order, moving the last element into the gap changes nothing observable.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `insert` | $O(1)$ average | |
| `remove` | $O(1)$ average | |
| `getRandom` | $O(1)$ | |
| Overall | | $O(n)$ |

## Notes
- **Why each step of `remove` is $O(1)$:** `list.set` overwrites a slot in place, and removing the last element of an `ArrayList` shifts nothing. Only a removal from the middle would cost $O(n)$.
- **Order of map updates:** `map.put(lastVal, idx)` must come before `map.remove(val)`. When `val` is itself the last element, the `put` briefly re-adds it, and the `remove` then deletes it. Reversing the two lines would leave `val` in the map.
- **`List<Integer>.remove` overloads:** `remove(int)` removes by index, while `remove(Object)` removes by value with an $O(n)$ search. Passing `list.size() - 1` calls the index version.
- **Single `Random` instance:** create it once as a field rather than on every `getRandom` call.
