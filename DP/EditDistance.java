public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)){
            return 0;
        }
        int sizea = word1.length();
        int sizeb = word2.length();
        int[][] dp = new int[sizea + 1][sizeb + 1];
        for (int i = 1; i <= sizeb; i++){
            dp[0][i] = i;
        }
        for (int i = 1; i <= sizea; i++){
            dp[i][0] = i;
        }
        for (int i = 0; i < sizea; i++){
            for (int j = 0; j < sizeb; j++){
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j];
                }else{
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j], Math.min(dp[i][j], dp[i][j + 1])) + 1;
                }
            }
        }
        return dp[sizea][sizeb];
    }
}