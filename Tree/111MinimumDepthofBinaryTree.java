111. Minimum Depth of Binary Tree

public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.right == null){
            return minDepth(root.left) + 1;
        }
        if (root.left == null){
            return minDepth(root.right) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int res = 1;
        while (!q.isEmpty()){
            int size = q.size();
            while (size > 0){
                TreeNode tmp = q.poll();
                if (tmp.left == null && tmp.right == null){
                    return res;
                }
                if (tmp.left != null){
                    q.offer(tmp.left);
                }
                if (tmp.right != null){
                    q.offer(tmp.right);
                }
                size--;
            }
            res++;
        }
        return res;
    }