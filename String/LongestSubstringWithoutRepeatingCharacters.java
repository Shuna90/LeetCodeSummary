public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        int first = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            int j = i;
            for (; j < s.length(); j++){
                if (map.containsKey(s.charAt(j))){
                    break;
                }
                map.put(s.charAt(j), j);
            }
            max = Math.max(max, map.entrySet().size());
            if (j == s.length()){
                return max;
            }
            int removeBefore = map.get(s.charAt(j));
            for (int k = first; k <= removeBefore; k++){
                map.remove(s.charAt(k));
            }
            first = removeBefore + 1;
            i = j - 1;
        }
        return max;
    }
}