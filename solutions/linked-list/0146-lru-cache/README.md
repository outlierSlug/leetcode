<!--
number: 0146
title: LRU Cache
pattern: linked-list
difficulty: Medium
languages: Java
slug: lru-cache
last_reviewed: 2026-10-29
-->
# LRU Cache
[Problem Description](https://leetcode.com/problems/lru-cache/description/)

Summary: Design a data structure for a Least Recently Used (LRU) cache with a fixed `capacity`. `get(key)` returns the key's value, or `-1` if it doesn't exist. `put(key, value)` inserts or updates the key, and if this makes the cache exceed `capacity`, evicts the least recently used key. Both operations must run in $O(1)$ average time.

## Algorithm
A hashmap combined with a doubly linked list.

Neither structure works alone. A hashmap finds keys in $O(1)$ but has no notion of order, and a linked list tracks order but takes $O(n)$ to search. Together:
- The **doubly linked list** keeps nodes in recency order, with the most recently used next to `dummyHead` and the least recently used next to `dummyTail`.
- The **hashmap** maps each key to its node, so any node can be reached in $O(1)$.

**Setup:** create sentinel nodes `dummyHead` and `dummyTail` and link them to each other. Real nodes always sit between them, so every node has non-null neighbors.

**Helpers:**
- `remove(node)`: link `node.prev` and `node.next` to each other.
- `addToFront(node)`: insert `node` between `dummyHead` and the current front.

**Operations:**
- `get(key)`: look up the node. If it's missing, return `-1`. Otherwise, `remove` it, `addToFront` it, and return its value.
- `put(key, value)`:
  - **Existing key:** update the node's value, then `remove` and `addToFront` it.
  - **New key:** create a node, add it to the map, and `addToFront` it. If the map's size now exceeds `capacity`, evict `dummyTail.prev`: `remove` it from the list and delete its key from the map.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `get` | $O(1)$ | |
| `put` | $O(1)$ | |
| Overall | | $O(\text{capacity})$ |

## Notes
- **Why doubly linked:** unlinking a node requires its predecessor. With only `next` pointers, finding it takes an $O(n)$ walk. The `prev` pointer makes removal $O(1)$.
- **Why each node stores its key:** on eviction, the LRU node is reached through the list, not the map. Its stored key is what allows deleting the matching map entry.
- **Sentinels remove edge cases:** with `dummyHead` and `dummyTail`, inserting into an empty cache and removing the first or last real node need no null checks. The LRU node is always `dummyTail.prev`.
- **Why not `java.util.LinkedList`:** it doesn't expose its nodes, so moving an element means `list.remove(obj)`, an $O(n)$ search. A custom node class lets the map point directly at nodes.
- **Built-in alternative:** `LinkedHashMap` with `accessOrder = true` and an overridden `removeEldestEntry` implements an LRU cache directly. It's the practical choice in production, but interviews typically expect the manual design.
- **Extension (LFU Cache, 460):** evict the least **frequently** used key instead. It extends this design with a map from frequency to a doubly linked list of nodes, plus a tracked minimum frequency.
- **Extension (thread safety):** for concurrent access, guard `get` and `put` with a lock. Since `get` also mutates the list, even reads need exclusive access.