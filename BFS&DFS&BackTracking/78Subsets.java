78. Subsets
/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Hide Company Tags
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return res;
        }
        List<Integer> list = new LinkedList<Integer>();
        dfs(res, list, nums, 0);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        res.add(new LinkedList<Integer>(list));
        for (int i = index; i < nums.length; i++){
            list.add(nums[i]);
            dfs(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}