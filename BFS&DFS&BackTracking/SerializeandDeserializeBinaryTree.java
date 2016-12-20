/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0){
            return null;
        }
        Deque<String> dq = new LinkedList<String>();
        dq.addAll(Arrays.asList(data.split(",")));
        return buildTree(dq);
    }
    public TreeNode buildTree(Deque<String> dq){
        String val = dq.remove();
        if (val.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(dq);
        node.right = buildTree(dq);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));