public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())){
            return false;
        }
        int size1 = s1.length();
        int size2 = s2.length();
        int size3 = s3.length();
        boolean[][] dp = new boolean[size1 + 1][size2 + 1];
        dp[0][0] = true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        for (int i = 1; i <= size1; i++){
            if (c1[i - 1] == c3[i - 1]){
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i <= size2; i++){
            if (c2[i - 1] == c3[i - 1]){
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= size1; i++){
            for (int j = 1; j <= size2; j++){
                if (c1[i - 1] == c3[i + j - 1] && dp[i - 1][j]){
                    dp[i][j] = true;
                }
                if (c2[j - 1] == c3[i + j - 1] && dp[i][j - 1]){
                    dp[i][j] = true;
                }
            }
        }
        return dp[size1][size2];
    }
}