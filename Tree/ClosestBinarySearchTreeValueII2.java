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
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> small = new Stack<TreeNode>();
        Stack<TreeNode> large = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        initialS(root, target, small);
        initialL(root, target, large);
        while (k-- > 0){
            if (small.isEmpty()){
                list.add(getSuccessor(large));
            }else if (large.isEmpty()){
                list.add(getPredecessor(small));
            }else if (Math.abs(small.peek().val - target) < Math.abs(large.peek().val - target)){
                list.add(getPredecessor(small));
            }else{
                list.add(getSuccessor(large));
            }
        }
        return list;
    }
    public void initialS(TreeNode root, double target, Stack<TreeNode> small){
        while (root != null){
            if (root.val <= target){
                small.push(root);
                root = root.right;
            }else{
                root = root.left;
            }
        }
    }
    
    public void initialL(TreeNode root, double target, Stack<TreeNode> large){
        while (root != null){
            if (root.val > target){
                large.push(root);
                root = root.left;
            }else{
                root = root.right;
            }
        }
    }
    
    public Integer getPredecessor(Stack<TreeNode> small){
        TreeNode cur = small.pop();
        int res = cur.val;
        cur = cur.left;
        while (cur != null){
            small.push(cur);
            cur = cur.right;
        }
        return res;
    }
    
    public Integer getSuccessor(Stack<TreeNode> large){
        TreeNode cur = large.pop();
        int res = cur.val;
        cur = cur.right;
        while (cur != null){
            large.push(cur);
            cur = cur.left;
        }
        return res;
    }
}