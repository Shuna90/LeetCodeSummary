110. Balanced Binary Tree

public boolean isBalanced(TreeNode root) {
        // write your code here
		return checkHeight(root) != -1;
    }
	
	public int checkHeight(TreeNode root){
	    if (root == null){
	        return 0;
	    }
	    int left = checkHeight(root.left);
	    int right = checkHeight(root.right);
	    if (left == -1 || right == -1 || Math.abs(right - left) > 1){
	        return -1;
	    }
	    return Math.max(left, right) + 1;
	}