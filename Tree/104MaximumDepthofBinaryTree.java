104. Maximum Depth of Binary Tree

public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int count = 0;
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        dq.offer(root);
        while (!dq.isEmpty()){
            int size = dq.size();
            while (size > 0){
                size--;
                TreeNode cur = dq.poll();
                if (cur.left != null){
                    dq.offer(cur.left);
                }
                if (cur.right != null){
                    dq.offer(cur.right);
                }
            }
            count++;
        }
        return count;
    }


