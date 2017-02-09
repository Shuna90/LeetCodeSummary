127. Word Ladder
/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
*/
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<>();
        dic.addAll(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int len = 1;
        while (!q.isEmpty()){
            int size = q.size();
            while (size > 0){
                size--;
                String s = q.poll();
                char[] cArray = s.toCharArray();
                for (int i = 0; i < cArray.length; i++){
                    for (char c = 'a'; c <= 'z'; c++){
                        char old = cArray[i];
                        cArray[i] = c;
                        String newS = new String(cArray);
                        if (newS.equals(endWord) && dic.contains(newS)){
                            return len + 1;
                        }
                        if (!visited.contains(newS) && dic.contains(newS)){
                            visited.add(newS);
                            q.offer(newS);
                        }
                        cArray[i] = old;
                    }
                }
            }
            len++;
        }
        return 0;
    }
}

public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

    int len = 1;
    int strLen = beginWord.length();
    HashSet<String> visited = new HashSet<String>();
    
    beginSet.add(beginWord);
    endSet.add(endWord);
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
        if (beginSet.size() > endSet.size()) {
            Set<String> set = beginSet;
            beginSet = endSet;
            endSet = set;
        }

        Set<String> temp = new HashSet<String>();
        for (String word : beginSet) {
            char[] chs = word.toCharArray();

            for (int i = 0; i < chs.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char old = chs[i];
                    chs[i] = c;
                    String target = String.valueOf(chs);

                    if (endSet.contains(target)) {
                        return len + 1;
                    }

                    if (!visited.contains(target) && wordList.contains(target)) {
                        temp.add(target);
                        visited.add(target);
                    }
                    chs[i] = old;
                }
            }
        }

        beginSet = temp;
        len++;
    }
    
    return 0;
}