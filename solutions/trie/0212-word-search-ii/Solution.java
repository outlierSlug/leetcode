import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int ROWS = board.length;
        int COLS = board[0].length;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                dfs(board, row, col, ROWS, COLS, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int row, int col, int ROWS, int COLS, TrieNode parent, List<String> result) {
        // Boundary checks
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) return;

        char c = board[row][col];

        // Check if the current character is already on the current path
        if (c == '#') return;

        // Trie pruning check: If the trie does not have a child for the current character, this path cannot form any valid word.
        int i = c - 'a';
        TrieNode node = parent.children[i];
        if (node == null) return;

        // If this character completes a word, add it to the result and mark it as null to prevent duplicates
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        // Mark the current character as visiting
        board[row][col] = '#';

        // Recurse
        dfs(board, row + 1, col, ROWS, COLS, node, result);
        dfs(board, row - 1, col, ROWS, COLS, node, result);
        dfs(board, row, col + 1, ROWS, COLS, node, result);
        dfs(board, row, col - 1, ROWS, COLS, node, result);

        // Backtrack
        board[row][col] = c;
    }

    // Constructs a trie from the given array of words
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        // Process every word in the words array
        for (String word : words) {
            TrieNode curr = root;  // start at the root
            for (char c : word.toCharArray()) {
                int i = c - 'a';

                // If the next character doesn't exist, create it
                if (curr.children[i] == null) {
                    curr.children[i] = new TrieNode();
                }

                // Step into the next character
                curr = curr.children[i];
            }
            // Mark the end of the word with the actual String word
            curr.word = word;
        }
        // Return the entire Trie from the root
        return root;
    }

    // Class definition for a TrieNode
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;  // non-null when this is the end of the word, store the word directly
    }
}