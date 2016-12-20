public class WordDictionary {
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
        public TrieNode getNode(int i){
            return arr[i];
        }
        public TrieNode getNode(char c){
            return arr[c - 'a'];
        }
        public void addNode(char c, TrieNode node){
            arr[c - 'a'] = node; 
        }
        public boolean getflag(){
            return isEnd;
        }
        public void setflag(){
            isEnd = true;
        }
    }
    
    TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode();
    }
    
    public boolean find(String word, int index, TrieNode node){
        if (index == word.length()){
            return node.getflag();
        }
        char c = word.charAt(index);
        if (c == '.'){
            for (int i = 0; i < 26; i++){
                TrieNode next = node.getNode(i);
                if (next != null){
                    if (find(word, index + 1, next)){
                        return true;
                    }
                }
            }
        }else{
            TrieNode next = node.getNode(c);
            if (next != null){
                return find(word, index + 1, next);
            }
        }
        return false;
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (node.getNode(c) == null){
                TrieNode newN = new TrieNode(c);
                node.addNode(c, newN);
            }
            node = node.getNode(c);
        }
        node.setflag();
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word, 0, root);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");