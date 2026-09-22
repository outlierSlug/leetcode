<!--
number: 0433
title: Minimum Genetic Mutation
pattern: graphs
difficulty: Medium
languages: Java
slug: minimum-genetic-mutation
last_reviewed: 2026-09-22
-->
# Minimum Genetic Mutation
[Problem Description](https://leetcode.com/problems/minimum-genetic-mutation/description/)

Summary: Given an 8-character `startGene`, `endGene`, and a `bank` of valid intermediate genes, return the minimum number of single-character mutations to reach `endGene` from `startGene`, where every gene in the path (except `startGene`) must be in `bank`. Return `-1` if impossible.

## Algorithm
"Minimum number of mutations" immediately signals BFS. The graph is implicit: every gene string is a node, with an edge between two gene strings that differ by exactly one character and both are valid (in the bank).

The "neighbors" of a given gene string is every possible single-character mutation: for each of the 8 positions in the string, a character can be changed to 3 other bases (`'A','C','G','T'`) excluding the current one. So each node has up to 24 possible neighbors. However, we must check first if this gene string has already been visited and that it is valid, i.e. it is in the gene bank, before enqueuing it.

```java
for (int pos = 0; pos < curr.length(); pos++) {
    for (char letter : letters) {
        if (curr.charAt(pos) == letter) continue;
        String mutated = curr.substring(0, pos) + letter + curr.substring(pos + 1);
        if (geneBank.contains(mutated) && !visited.contains(mutated)) {
            visited.add(mutated);
            queue.offer(mutated);
        }
    }
}
```

`substring` concatenation works cleanly here since `String` is immutable, i.e. each call produces a fresh string, leaving `curr` untouched. A `char[]`-based alternative (mutate one index, then `new String(...)`) is marginally more efficient but more verbose.

## Complexity
Let `B = bank.length` and `L = 8`, which is the length of a gene string.

| Time | Space |
|---|---|
| `O(B * L^2)`| `O(B * L)` |

## Notes
- At most `B` genes are ever enqueued (bounded by bank membership). Per dequeue, 24 candidate mutations are tried, each costing `O(L)` to build via substring concatenation and `O(L)` to hash/compare in the set lookups, which gives `O(L^2)` per dequeue, `O(B * L^2)` overall.
- Note that `L` is technically a constant, but this is the most accurate runtime bound for the problem.
- Checking `endGene`'s presence in `bank` upfront isn't strictly required for correctness (BFS would still correctly exhaust and return `-1` otherwise, since only bank members are ever generated as candidates), but it's a cheap early-exit optimization.
