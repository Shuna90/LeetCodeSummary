class TrieNode {
    char c;
    TrieNode[] arr;
    boolean isEnd;
    // Initialize your data structure here.
    public TrieNode() {
        c = ' ';
        arr = new TrieNode[26];
        isEnd = false;
    }
    public TrieNode(char c) {
        this.c = c;
        arr = new TrieNode[26];
        isEnd = false;
    }
    public TrieNode getLetter(int index){
        return arr[index];
    }
    public void addLetter(TrieNode node, int index){
        arr[index] = node;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0){
            return;
        }
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if (now.getLetter(index) == null){
                TrieNode newNode = new TrieNode(c);
                now.addLetter(newNode, index);
            }
            now = now.getLetter(index);
        }
        now.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0){
            return true;
        }
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if (now.getLetter(index) == null){
                return false;
            }
            now = now.getLetter(index);
        }
        if (now.isEnd){
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0){
            return false;
        }
        TrieNode now = root;
        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (now.getLetter(index) == null){
                return false;
            }
            now = now.getLetter(index);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");