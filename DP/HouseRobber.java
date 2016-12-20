public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int size = nums.length;
        int[] dp = new int[size + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < size; i++){
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }
        return dp[size];
    }
}