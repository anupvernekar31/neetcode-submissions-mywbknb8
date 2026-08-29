class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add word to trie
    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.isWord = true;
    }

    // Search word with '.' support
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        // reached end of word
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);

        // if character is '.'
        if (c == '.') {

            // try all possible children
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }

            return false;
        }

        // normal character
        int idx = c - 'a';

        if (node.children[idx] == null) {
            return false;
        }

        return dfs(word, index + 1, node.children[idx]);
    }
}