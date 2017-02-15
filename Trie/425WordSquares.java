425. Word Squares

/*

Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

*/

class TrieNode{
        List<String> list;
        TrieNode[] arr;
        public TrieNode(){
            list = new ArrayList<>();
            arr = new TrieNode[26];
        }
    }
    
    class Trie{
        TrieNode root;
        
        public Trie(String[] word){
            root = new TrieNode();
            for (String s : word){
                TrieNode cur = root;
                for (char c : s.toCharArray()){
                    int idx = c - 'a';
                    if (cur.arr[idx] == null){
                        cur.arr[idx] = new TrieNode();
                    }
                    cur.arr[idx].list.add(s);
                    cur = cur.arr[idx];
                }
            }
        }
        
        public List<String> getPrefix(String prefix){
            List<String> ans = new ArrayList<String>();
            TrieNode cur = root;
            for (char c : prefix.toCharArray()){
                int idx = c - 'a';
                if (cur.arr[idx] == null){
                    return ans;
                }
                cur = cur.arr[idx];
            }
            ans.addAll(cur.list);
            return ans;
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<List<String>>();
        int size = words[0].length();
        Trie trie = new Trie(words);
        for (String s : words){
            char[][] arr = new char[size][size];
            for (int i = 0; i < size; i++){
                arr[0][i] = arr[i][0] = s.charAt(i);
            }
            helper(res, trie, arr, 1, size);
        }
        return res;
    }
    public void helper(List<List<String>> res, Trie trie, char[][] arr, int pos, int size){
        if (pos == size){
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < size; i++){
                list.add(new String(arr[i]));
            }
            res.add(list);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos; i++){
            sb.append(arr[pos][i]);
        }
        List<String> strings = trie.getPrefix(sb.toString());
        for (String s : strings){
            if (s.substring(0, pos).equals(sb.toString())){
                for (int i = pos; i < size; i++){
                    arr[pos][i] = arr[i][pos] = s.charAt(i);
                }
                helper(res, trie, arr, pos + 1, size);
            }
        }
    }