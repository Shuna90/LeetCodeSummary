public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        int size = nums.length;
        int max = 0;
        for (int i = 0; i < k; i++){
            max = Math.max(max, nums[i]);
        }
        int[] res = new int[size - k + 1];
        res[0] = max;
        for (int i = k; i < size; i++){
            if (nums[i] >= max){
                max = nums[i];
            }else{
                if (max == nums[i - k]){
                    max = nums[i - k + 1];
                    for (int j = i - k + 1; j <= i; j++){
                        max = Math.max(max, nums[j]);
                    }
                }
            }
            res[i - k + 1] = max;
        }
        return res;
    }
}