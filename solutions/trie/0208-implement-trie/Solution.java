class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';

            // If the next character in the word doesn't exist, create it
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            // Step into the next character
            curr = curr.children[i];
        }

        // Mark the  end of the word
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) return false;
            curr = curr.children[i];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) return false;
            curr = curr.children[i];
        }
        return true;
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];  // indices 0-25 represent a-z
        boolean isEnd;  // true if a word ends at this node
    }
}