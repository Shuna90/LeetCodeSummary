public class Solution {
    public boolean isMatch(String s, String p) {
        int sizea = s.length();
        int sizeb = p.length();
        boolean[][] dp = new boolean[sizea + 1][sizeb + 1];
        dp[0][0] = true;
        for (int i = 1; i <= sizeb; i++){
            char c = p.charAt(i - 1);
            if (c == '*'){
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= sizea; i++){
            for (int j = 1; j <= sizeb; j++){
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc == '.' || sc == pc){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pc == '*'){
                    if (dp[i][j-2]){
                        dp[i][j] = true;
                    }else if(sc == p.charAt(j-2) || p.charAt(j-2)=='.'){
                        dp[i][j] = dp[i-1][j];
                        // opt[i-1][j] do take s[i] to match p[j-1],p[j]
                        // opt[i][j-2] don't take s[i] to match p[j-1],p[j]
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[sizea][sizeb];
    }
}