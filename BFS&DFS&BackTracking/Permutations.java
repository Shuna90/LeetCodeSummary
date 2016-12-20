public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        if (nums == null || nums.length == 0){
            return res;
        }
        permutation(nums, list, res);
        return res;
    }
    public void permutation(int[] nums, List<Integer> list, List<List<Integer>> res){
        if (list.size() == nums.length){
            res.add(new LinkedList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!list.contains(nums[i])){
                list.add(nums[i]);
                permutation(nums, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return res;
        }
        permutation(nums, 0, res);
        return res;
    }
    public void permutation(int[] nums, int start, List<List<Integer>> res){
        if (start == nums.length - 1){
            List<Integer> list = new LinkedList<Integer>();
            for (int i : nums){
                list.add(i);
            }
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++){
            int tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;
            permutation(nums, start + 1, res);
            tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;
        }
    }
}