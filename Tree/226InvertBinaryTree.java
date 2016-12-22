226. Invert Binary Tree
public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        dq.offer(root);
        while (!dq.isEmpty()){
            TreeNode cur = dq.poll();
            TreeNode left= cur.left;
            TreeNode right = cur.right;
            cur.left = right;
            cur.right = left;
            if (cur.left != null){
                dq.offer(cur.left);
            }
            if (cur.right != null){
                dq.offer(cur.right);
            }
        }
        return root;
    }