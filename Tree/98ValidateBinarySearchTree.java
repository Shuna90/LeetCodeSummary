98. Validate Binary Search Tree

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
*/

public boolean isValidBST(TreeNode root) {
        return isValidHelper(root, null, null);
    }
    public boolean isValidHelper(TreeNode root, Integer min, Integer max){
        if (root == null){
            return true;
        }
        if (min != null && root.val <= min){
            return false;
        }
        if (max != null && root.val >= max){
            return false;
        }
        return isValidHelper(root.left, min, root.val) && isValidHelper(root.right, root.val, max);
    }