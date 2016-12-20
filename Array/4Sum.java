public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums == null || nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++){
                if (j != i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int s = j + 1, e = nums.length - 1;
                while (s < e){
                    int sum = nums[i] + nums[j] + nums[s] + nums[e];
                    if (sum == target){
                        List<Integer> tmp = new LinkedList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[s]);
                        tmp.add(nums[e]);
                        res.add(tmp);
                        s++;
                        while (s < e && nums[s] == nums[s - 1]){
                            s++;
                        }
                        while (e > s && e < nums.length - 1 && nums[e] == nums[e + 1]){
                            e--;
                        }
                    }else if (sum > target){
                        e--;
                    }else{
                        s++;
                    }
                }
            }
        }
        return res;
    }
}