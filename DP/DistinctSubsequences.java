public class Solution {
    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        int[][] dp = new int[ls + 1][lt + 1];
        for (int i = 0; i <= ls; i++){
            dp[i][0] = 1;
        }
        for (int i = 0; i < ls; i++){
            for (int j = 0; j < lt; j++){
                dp[i + 1][j + 1] = dp[i][j + 1];
                if (s.charAt(i) == t.charAt(j)){
                    dp[i + 1][j + 1] += dp[i][j];
                }
            }
        }
        return dp[ls][lt];
    }
}