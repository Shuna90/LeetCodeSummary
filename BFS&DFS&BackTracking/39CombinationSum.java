39. Combination Sum

/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/

public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0){
        	return res;
        }
        Arrays.sort(candidates);
        List<Integer> solution = new ArrayList<Integer>();
        helper(res, solution, target, candidates, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> solution, 
			int target, int[] candidates, int index){
	    if (target < 0){
	        return;
	    }
		if (target == 0){
			res.add(new ArrayList<Integer>(solution));
			return;
		}
		
		for (int i = index; i < candidates.length; i++){
			solution.add(candidates[i]);
			helper(res, solution, target - candidates[i], candidates, i);
			solution.remove(solution.size() - 1);
		}
	}