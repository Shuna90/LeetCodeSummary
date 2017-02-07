297. Serialize and Deserialize Binary Tree

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/

private static String splitter = ",";
    private static String nullSplitter = "N";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public void serializeHelper(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(nullSplitter).append(splitter);
            return;
        }
        sb.append(root.val).append(splitter);
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(splitter);
        Deque<String> res = new LinkedList<>();
        res.addAll(Arrays.asList(arr));
        return deserialHelper(res);
    }
    
    public TreeNode deserialHelper(Deque<String> res){
        String cur = res.remove();
        if (cur.equals(nullSplitter)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = deserialHelper(res);
        node.right = deserialHelper(res);
        return node;
    }