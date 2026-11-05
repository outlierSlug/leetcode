class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();    
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';

            // Create the child node if it doesn't exist
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }

            // Step into the child node
            curr = curr.children[i];
        }

        // Mark the end of the word
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // Returns true if word[i..] can be matched starting from node
    private boolean dfs(String word, int i, TrieNode node) {
        // Base Case: the whole word is matched, must be a valid end node
        if (i == word.length()) return node.isEnd;

        char c = word.charAt(i);
        if (c == '.') {
            // Wildcard: try every existing child node
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, i + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Regular letter: follow child path
            TrieNode child = node.children[c - 'a'];
            if (child == null) return false;
            return dfs(word, i + 1, child);
        }
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
}