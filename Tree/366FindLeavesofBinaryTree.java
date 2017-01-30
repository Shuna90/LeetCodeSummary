366. Find Leaves of Binary Tree
/*
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].
*/
public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res =  new ArrayList<List<Integer>>();
        findLeavesHelper(root, res);
        return res;
    }
    
    public int findLeavesHelper(TreeNode root, List<List<Integer>> res){
        if (root == null){
            return -1;
        }
        int level = Math.max(findLeavesHelper(root.left, res), findLeavesHelper(root.right, res)) + 1;
        if (res.size() < level + 1){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        return level;
    }