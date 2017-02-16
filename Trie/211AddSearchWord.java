211. Add and Search Word - Data structure design
/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

public class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public String item = "";
        }
        
        private TrieNode root = new TrieNode();
    
        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }
    
        public boolean search(String word) {
            return match(word.toCharArray(), 0, root);
        }
        
        private boolean match(char[] chs, int k, TrieNode node) {
            if (k == chs.length) return !node.item.equals("");   
            if (chs[k] != '.') {
                return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
            } else {
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] != null) {
                        if (match(chs, k + 1, node.children[i])) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }



public class WordDictionary {
    // Adds a word into the data structure.
    public class TrieNode{
        char c;
        TrieNode[] arr;
        boolean isEnd;
        public TrieNode(){
            c = ' ';
            arr = new TrieNode[26];
            isEnd = false;
        }
        public TrieNode(char c){
            this.c = c;
            arr = new TrieNode[26];
            isEnd = false;
        }
        public TrieNode getLetter(int index){
            return arr[index];
        }
        public void addLetter(int index, TrieNode node){
            arr[index] = node;
        }
    }
    
    TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        if (word == null || word.length() == 0){
            return;
        }
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if (now.getLetter(index) == null){
                TrieNode node = new TrieNode(c);
                now.addLetter(index, node);
            }
            now = now.getLetter(index);
        }
        now.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.length() == 0){
            return true;
        }
        return searchUtil(word, 0, root);
    }
    public boolean searchUtil(String word, int index, TrieNode node){
        if (index == word.length()){
            if (node.isEnd){
                return true;
            }
            return false;
        }
        char c = word.charAt(index);
        if (c == '.'){
            for (int i = 0; i < 26; i++){
                if (node.getLetter(i) != null){
                    if (searchUtil(word, index + 1, node.getLetter(i))){
                        return true;
                    }
                }
            }
            return false;
        }
        if (node.getLetter(c - 'a') == null){
            return false;
        }
        return searchUtil(word, index + 1, node.getLetter(c - 'a'));
    }

}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");