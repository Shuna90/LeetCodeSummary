404. Sum of Left Leaves

public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        int res = 0;
        if (root.left != null){
            res += sumOfLeftLeaves(root.left);
            if (root.left.left == null && root.left.right == null){
                res += root.left.val;
            }
        }
        if (root.right != null){
            res += sumOfLeftLeaves(root.right);
        }
        return res;
    }

public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        dq.offer(root);
        int res = 0;
        while (!dq.isEmpty()){
            TreeNode cur = dq.pop();
            if (cur.left != null){
                if (cur.left.left == null && cur.left.right == null){
                    res += cur.left.val;
                }else{
                    dq.push(cur.left);
                }
            }
            if (cur.right != null){
                if (cur.right.left != null || cur.right.right != null)
                dq.push(cur.right);
            }
        }
        return res;
    }