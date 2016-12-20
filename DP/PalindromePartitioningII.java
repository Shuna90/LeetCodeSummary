public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int size = s.length();
        int[] dp = new int[size + 1];
        dp[0] = -1;
        boolean[][] p = palindrome(s);
        for (int i = 0; i < size; i++){
            dp[i + 1] = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++){
                if (p[j][i]){
                    dp[i + 1] = Math.min(dp[j] + 1, dp[i + 1]);
                }
            }
        }
        return dp[size];
    }
    public boolean[][] palindrome(String s){
	        int size = s.length();
	        boolean[][] dp = new boolean[size][size];
	        for (int i = 0; i < size; i++){
	            for (int j = 0; j <= i ; j++){
	                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])){
	                    dp[j][i] = true;
	                }
	            }
	        }
	        return dp;
	    }
}