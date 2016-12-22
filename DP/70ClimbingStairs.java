public class Solution {
    public int climbStairs(int n) {
        if (n == 0){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public int climbStairs(int n) {
        int prepre = 1;
        int pre = 1;
        int cur = 1;
        for (int i = 2; i <= n; i++){
            cur = pre + prepre;
            prepre = pre;
            pre = cur;
        }
        return cur;
    }
}