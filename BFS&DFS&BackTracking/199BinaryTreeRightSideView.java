199. Binary Tree Right Side View

/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Credits:
Special thanks to @amrsaqr for adding this problem and creating all test cases.
*/

public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int rightNode = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if (i == 0){
                    res.add(cur.val);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
                if (cur.left != null){
                    q.offer(cur.left);
                }
            }
        }
        return res;
    }


public List<Integer> rightSideView(TreeNode root) {
        ArrayList list = new ArrayList();
        rightSideView(root, 0, list);
        
        return list;
    }
    
    public void rightSideView(TreeNode root, int level, ArrayList list) {
        if(root == null) return;

        if(list.size() == level)
            list.add(root.val);

        rightSideView(root.right, level + 1, list);
        rightSideView(root.left, level + 1, list);
    }