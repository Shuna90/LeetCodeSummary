public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            int s = i + 1, e = nums.length - 1;
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            while (s < e){
                if (nums[i] + nums[s] + nums[e] == 0){
                    List<Integer> tmp = new LinkedList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[s]);
                    tmp.add(nums[e]);
                    res.add(tmp);
                    s++;
                    e--;
                    while(s < e && nums[s] == nums[s - 1]){
                        s++;
                    }
                    while(s < e && nums[e] == nums[e + 1]){
                        e--;
                    }
                }else if (nums[i] + nums[s] + nums[e] < 0){
                    s++;
                }else{
                    e--;
                }
            }
        }
        return res;
    }
}