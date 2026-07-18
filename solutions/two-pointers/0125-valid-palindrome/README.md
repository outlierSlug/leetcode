# Valid Palindrome
[Problem Description](https://leetcode.com/problems/valid-palindrome/description/)

Summary: Given a string, check if it is a palindrome or not.

## Algorithm
We will use two pointers, one at each end of the string. The `lo` pointer will start at the first character in the string, and the `hi` pointer will start at the end. Then, we will run a while loop until the pointers "meet in the middle" with the following cases:

1. The current character the pointer is at is a non-alphanumeric character. We simply skip it by incrementing `lo` or decrementing `hi` respectively. 
2. The characters being pointed to by `lo` and `hi` are not the same. We return false because the string is no longer a valid palindrome. The symmetry required has been broken.

Finally,  we return true after the loop runs, as the string has passed all the checks and meets the requirements for a valid palindrome. 

## Complexity

| Approach | Time | Space |
|---|---|---|
| Two Pointers | `O(n)` | `O(1)` |

## Notes
The empty string is considered a palindrome, so our algorithm will return true if that is the input (the entire while loop will be skipped).