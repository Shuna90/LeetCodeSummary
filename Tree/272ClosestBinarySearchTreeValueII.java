272. Closest Binary Search Tree Value II

/*
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

Hint:

Consider implement these two helper functions:
getPredecessor(N), which returns the next smaller node to N.
getSuccessor(N), which returns the next larger node to N.
Try to assume that each node has a parent pointer, it makes the problem much easier.
Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
You would need two stacks to track the path in finding predecessor and successor node separately.
*/

public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<Integer> pre = new Stack<>();
        Stack<Integer> nxt = new Stack<>();
        
        inorder(root, pre, false, target);
        inorder(root, nxt, true, target);
        
        while (k-- > 0){
            if (pre.isEmpty()){
                res.add(nxt.pop());
            }else if (nxt.isEmpty()){
                res.add(pre.pop());
            }else if (Math.abs(target - pre.peek()) < Math.abs(target - nxt.peek())){
                res.add(pre.pop());
            }else{
                res.add(nxt.pop());
            }
        }
        return res;
    }
    
    public void inorder(TreeNode root, Stack<Integer> s, boolean reverse, double target){
        if (root == null){
            return;
        }
        inorder(reverse ? root.right : root.left, s, reverse, target);
        if (!reverse && root.val > target || reverse && root.val <= target){
            return;
        }
        s.push(root.val);
        inorder(reverse ? root.left : root.right, s, reverse, target);
    }