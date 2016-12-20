public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[][] dp = new int[nums.length][nums.length];
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length; j++){
            dp[j][j] = nums[j];
            max = Math.max(max, dp[j][i]);
            for (int i = j - 1; i >= 0; i--){
                dp[j][i] = dp[j - 1][i] * nums[j];
                max = Math.max(max, dp[j][i]);
            }
        }
        return max;
    }

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] >= 0){
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            }else if (nums[i] < 0){
                int tmp = min;
                min = Math.min(nums[i], max * nums[i]);
                max = Math.max(nums[i], tmp * nums[i]);
            }
            res = Math.max(res, max);
        }
        return res;
    }
}