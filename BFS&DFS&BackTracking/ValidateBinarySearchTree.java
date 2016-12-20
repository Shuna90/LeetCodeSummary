/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int min = Integer.MIN_VALUE;
    boolean first = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean left = isValidBST(root.left);
        if (first){
            first = false;
            min = root.val;
        }else{
            if (root.val <= min){
                return false;
            }
            min = root.val;
        }
        boolean right = isValidBST(root.right);
        return left & right;
    }
    
}