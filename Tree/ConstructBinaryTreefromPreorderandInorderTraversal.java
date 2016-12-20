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
    
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<Integer, Integer>();
        index = 0;
        int size = preorder.length;
        if (size == 0){
            return null;
        }
        for (int i = 0; i < size; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, inorder,0, size - 1);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int low, int high){
        if (low == high){
            index++;
            return new TreeNode(inorder[low]);
        }
        if (low > high){
            return null;
        }
        TreeNode cur = new TreeNode(preorder[index]);
        int mid = map.get(preorder[index++]);
        TreeNode left = buildTree(preorder, inorder, low, mid - 1);
        TreeNode right = buildTree(preorder, inorder,  mid + 1, high);
        cur.left = left;
        cur.right = right;
        return cur;
    }
    
}