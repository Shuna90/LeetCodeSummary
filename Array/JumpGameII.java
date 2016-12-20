public class Solution {
    public int jump(int[] nums) {
        int index = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++){
            int max = i + nums[i];
            for (int j = pre + 1; j <= max && j < nums.length; j++){
                dp[j] = dp[i] + 1;
            }
            pre = Math.max(max, pre);
        }
        return dp[nums.length - 1];
    }
}