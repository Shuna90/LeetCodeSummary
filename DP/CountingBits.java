public class Solution {
    public int[] countBits(int num) {
        if (num <= 0){
            return new int[]{0};
        }
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (num == 1){
            return dp;
        }
        for (int i = 1; i < 32; i++){
            int pre = 1 << (i - 1);
            int start = 1 << i;
            int end = 1 << (i + 1);
            dp[start] = 1;
            for (int j = start + 1; j < end && j <= num; j++){
                dp[j] = dp[start] + dp[j - start];
            }
            if (dp[num] != 0){
                break;
            }
        }
        return dp;
    }
}