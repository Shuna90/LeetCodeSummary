public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++){
            int s = i + 1, e = nums.length - 1;
            while (s < e){
                if (nums[i] + nums[s] + nums[e] < target){
                    count += e - s;
                    s++;
                }else{
                    e--;
                }
            }
        }
        return count;
    }
}