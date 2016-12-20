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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<Integer, Integer>();
        int size = inorder.length;
        if (size == 0){
            return null;
        }
        index = size - 1;
        for (int i = 0; i < size; i++){
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, size - 1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int low, int high){
        if (low == high){
            return new TreeNode(postorder[index--]);
        }
        if (low > high){
            return null;
        }
        TreeNode cur = new TreeNode(postorder[index]);
        int mid = map.get(postorder[index--]);
        TreeNode right = build(inorder, postorder, mid + 1, high);
        TreeNode left = build(inorder, postorder, low, mid - 1);
        cur.left = left;
        cur.right = right;
        return cur;
    }
}