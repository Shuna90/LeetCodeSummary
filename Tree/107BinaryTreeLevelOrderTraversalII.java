107. Binary Tree Level Order Traversal II
public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        dq.offer(root);
        while (!dq.isEmpty()){
            int size = dq.size();
            List<Integer> list = new LinkedList<Integer>();
            while (size-- > 0){
                TreeNode cur = dq.poll();
                list.add(cur.val);
                if (cur.left != null){
                    dq.offer(cur.left);
                }
                if (cur.right != null){
                    dq.offer(cur.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }