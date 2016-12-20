public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++){
            int low = i + 1, high = nums.length - 1;
            while (low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if (sum == target){
                    return target;
                }else if (sum < target){
                    low++;
                }else{
                    high--;
                }
            }
        }
        return res;
    }
}