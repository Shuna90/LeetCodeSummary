public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = words.length;
        Integer index1 = null, index2 = null;
        for (int i = 0; i < words.length; i++){
            String s = words[i];
            if (s.equals(word1)){
                index1 = i;
            }else if (s.equals(word2)){
                index2 = i;
            }
            if (index1 != null && index2 != null){
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        return min;
    }
}