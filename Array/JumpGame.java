public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return true;
        }
        int index = nums[0]; 
        for (int i = 0; i <= index && i < nums.length; i++){
            index = Math.max(i + nums[i], index);
        }
        return index >= nums.length - 1 ? true : false;
    }
}