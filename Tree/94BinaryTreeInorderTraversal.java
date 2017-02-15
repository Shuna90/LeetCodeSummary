94. Binary Tree Inorder Traversal

/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> array = new ArrayList<Integer>();
		TreeNode current = root;
		while (current != null || !stack.isEmpty()){
			while (current != null){
				stack.add(current);
				current = current.left;
			}
			current = stack.pop();
			array.add(current.val);
			current = current.right;
		}
		return array;
    }