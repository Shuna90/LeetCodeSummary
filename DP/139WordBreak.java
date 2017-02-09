139. Word Break
/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLength = 0;
        int size = s.length();
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        for (String st : wordDict){
            maxLength = Math.max(maxLength, st.length());
        }
        for (int i = 1; i <= size; i++){
            dp[i] = false;
            for (int j = i - 1; j >= 0 && j >= i - maxLength; j--){
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[size];
    }
}