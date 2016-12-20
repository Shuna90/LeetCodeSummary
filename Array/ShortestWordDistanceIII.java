public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1;
        boolean flag;
        int min = words.length;
        if (word1.equals(word2)){
            for (int i = 0; i < words.length; i++){
                if (words[i].equals(word1)){
                    index1 = index2;
                    index2 = i;
                    if (index1 != -1){
                        min = Math.min(min, index2 - index1);
                    }
                }
            }
        }else{
            for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1)){
                index1 = i;
            }
            if (words[i].equals(word2)){
                index2 = i;
            }
            if (index1 != -1 && index2 != -1){
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        }
        
        return min;
    }
}