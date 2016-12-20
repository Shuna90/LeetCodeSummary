public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        permutation(nums, res, 0);
        return res;
    }
    public void permutation(int[] nums, List<List<Integer>> res, int index){
        if (index == nums.length - 1){
            List<Integer> list = new LinkedList<Integer>();
            for (int i : nums){
                list.add(i);
            }
            res.add(list);
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = index; i < nums.length; i++){
            if (i != index && (nums[i] == nums[index] || set.contains(nums[i]))){
                continue;
            }
            set.add(nums[i]);
            int tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
            permutation(nums, res, index + 1);
            tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
        }
    }
}