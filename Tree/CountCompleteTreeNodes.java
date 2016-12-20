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
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        TreeNode tmp = root;
        int height = -1;
        while (tmp != null){
            height++;
            tmp = tmp.left;
        }
        return helper(root, height);
    }
    public int helper(TreeNode root, int level){
        if (root == null){
            return 0;
        }
        TreeNode tmp = root.right;
        int h = 0;
        while (tmp != null){
            h++;
            tmp = tmp.left;
        }
        if (h == level){
            return (1 << level) + helper(root.right, level - 1);
        }else{
            return (1 << h) + helper(root.left, h);
        }
    }
}