113. Path Sum II

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null){
            return res;
        }
        List<Integer> solution = new ArrayList<Integer>();
        helper(res, solution, root, sum);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> solution, TreeNode root, int sum){
        if (root == null){
            return;
        }
        solution.add(root.val);
        if (root.left == null && root.right == null && sum == root.val){
            res.add(new ArrayList<Integer>(solution));
            solution.remove(solution.size() - 1);
            return;
        }
        helper(res, solution, root.left, sum - root.val);
        helper(res, solution, root.right, sum - root.val);
        solution.remove(solution.size() - 1);
    }