public class Solution {
    public int numSquares(int n) {
        if (n <= 0){
            return 0;
        }
        int sqrt = (int)Math.sqrt(n);
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++){
            dp[i] = i;
        }
        for (int i = 2; i <= sqrt; i++){
            int sq = i * i;
            for (int j = sq; j <= n; j++){
                dp[j] = Math.min(dp[j], dp[j - sq] + 1);
            }
        }
        return dp[n];
    }
}