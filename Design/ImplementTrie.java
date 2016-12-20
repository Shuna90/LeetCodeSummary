class TrieNode {
    // Initialize your data structure here.
    TrieNode[] arr;
    
    char letter;
    
    boolean isEnd;
    
    public TrieNode() {
        letter = ' ';
        arr = new TrieNode[26];
        isEnd = false;
    }
    
    public TrieNode(char c) {
        letter = c;
        arr = new TrieNode[26];
        isEnd = false;
    }
    
    public TrieNode getNode(char c){
        return arr[c - 'a'];
    }
    
    public void addNode(char c, TrieNode node){
        arr[c - 'a'] = node;
    }
    
    public void setEnd(){
        isEnd = true;
    }
    
    public boolean isEnd(){
        return isEnd;
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
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (cur.getNode(c) == null){
                TrieNode newN = new TrieNode(c);
                cur.addNode(c, newN);
            }
            cur = cur.getNode(c);
        }
        cur.setEnd();
    }

    public TrieNode searchPrefix(String word){
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode tmp = cur.getNode(c);
            if (tmp == null){
                return null;
            }
            cur = tmp;
        }
        return cur;
    }
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");