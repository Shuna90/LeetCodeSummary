public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict == null || s == null || s.length() == 0){
            return false;
        }
        int maxLength = 0;
        for (String word : wordDict){
            maxLength = Math.max(maxLength, word.length());
        }
        int size = s.length();
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        for (int i = 1; i <= size; i++){
            for (int j = Math.max(0, i - 1 - maxLength); j < i; j++){
                String sub = s.substring(j, i);
                if (dp[j] && wordDict.contains(sub)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[size];
    }
}