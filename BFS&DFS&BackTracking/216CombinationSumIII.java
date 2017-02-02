216. Combination Sum III
/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/
public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k < 1 || n < k){
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        helper(k, n, 1, res, list);
        return res;
    }
    public void helper(int k, int n, int start, List<List<Integer>> res, List<Integer> list){
        if (list.size() > k){
            return;
        }
        if (0 == n && k == list.size()){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= 9; i++){
            if (i > n){
                return;
            }
            list.add(i);
            helper(k, n - i, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }