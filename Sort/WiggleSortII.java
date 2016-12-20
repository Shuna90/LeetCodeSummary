public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        int mid = (nums.length - 1) / 2;
        int index = 0;
        for (int i = 0; i <= mid; i++){
            tmp[index] = nums[mid - i];
            if (index + 1 < nums.length){
                tmp[index + 1] = nums[nums.length - i - 1];
            }
            index += 2;
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = tmp[i];
        }
    }
}