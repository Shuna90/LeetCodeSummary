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
    Stack<Integer> small;
    Stack<Integer> large;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
       small = new Stack<Integer>();
       large = new Stack<Integer>();
       getPredecessor(root, target);
       getSuccessor(root, target);
       List<Integer> list = new LinkedList<Integer>();
       while (k-- > 0){
           if (small.isEmpty()){
               list.add(large.pop());
           }else if (large.isEmpty()){
               list.add(small.pop());
           }else if (Math.abs(target - small.peek()) < Math.abs(target - large.peek())){
               list.add(small.pop());
           }else{
               list.add(large.pop());
           }
       }
       return list;
    }
    
    public void getPredecessor(TreeNode n, double target){
        if (n == null){
            return;
        }
        getPredecessor(n.left, target);
        if (n.val > target){
            return;
        }
        small.push(n.val);
        getPredecessor(n.right, target);
    }
    public void getSuccessor(TreeNode n, double target){
        if (n == null){
            return;
        }
        getSuccessor(n.right, target);
        if (n.val <= target){
            return;
        }
        large.push(n.val);
        getSuccessor(n.left, target);
    }
}