public class Solution {
    public boolean isMatch(String s, String p) {
        int sizes = s.length();
        int sizep = p.length();
        boolean[][] dp = new boolean[sizes + 1][sizep + 1];
        dp[0][0] = true;
        for (int i = 1; i <= sizep; i++){
            if (p.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= sizes; i++){
            for (int j = 1; j <= sizep; j++){
                char sc = s.charAt(i - 1);
                char sp = p.charAt(j - 1);
                if (sp == '?' || sp == sc){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (sp == '*'){
                    if (dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j]){
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[sizes][sizep];
    }
}