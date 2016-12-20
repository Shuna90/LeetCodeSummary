public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int size = nums.length;
        int k = -1, l = -1;
        for (int i = size - 2; i >= 0; i--){
            if (nums[i] < nums[i + 1]){
                k = i;
                break;
            }
        }
        if (k == -1){
            reverse(nums, 0, size - 1);
            return;
        }
        for (int i = size - 1; i > k; i--){
            if (nums[i] > nums[k]){
                l = i;
                break;
            }
        }
        swap(nums, k, l);
        reverse(nums, k + 1, size - 1);
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int[] nums, int i, int j){
        while (i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}