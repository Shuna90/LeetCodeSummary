public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)){
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put(beginWord, 1);
        int count = 1;
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        while (!q.isEmpty()){
            int size = q.size();
            for (int k = 0; k < size; k++){
                char[] tmp = q.poll().toCharArray();
                for (int i = 0; i < tmp.length; i++){
                    char c = tmp[i];
                    for (char j = 'a'; j <= 'z'; j++){
                        if (j == tmp[i]){
                            continue;
                        }
                        tmp[i] = j;
                        String s = new String(tmp);
                        if (s.equals(endWord)){
                            return count + 1;
                        }
                        if (wordList.contains(s) && !map.containsKey(s)){
                            map.put(s, 1);
                            q.offer(s);
                        }
                        tmp[i] = c;
                    }
                }
            }
            count++;
        }
        return 0;
    }
}