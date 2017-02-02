230. Kth Smallest Element in a BST
/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
*/

public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null){
            stack.push(root);
            root = root.left;
        }
        while (k > 0){
            TreeNode cur = stack.pop();
            k--;
            if (k == 0){
                return cur.val;
            }
            TreeNode right = cur.right;
            while (right != null){
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }