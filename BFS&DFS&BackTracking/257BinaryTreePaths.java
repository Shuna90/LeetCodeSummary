257. Binary Tree Paths
public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<String>();
        if (root == null){
            return res;
        }
        helper(root, res, "");
        return res;
    }
    public void helper(TreeNode root, List<String> res, String s){
        if (root.left == null && root.right == null){
            s = s + root.val;
            res.add(new String(s));
            return;
        }
        if (root.left != null){
           helper(root.left, res, s + root.val + "->");
        }
        if (root.right != null){
            helper(root.right, res, s + root.val + "->");
        }
    }