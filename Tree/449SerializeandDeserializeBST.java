449. Serialize and Deserialize BST

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/

private String splitter = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serializehelper(root, res);
        return res.toString();
    }
    
    public void serializehelper(TreeNode root, StringBuilder sb){
        if (root == null){
            return;
        }
        sb.append(root.val).append(splitter);
        serializehelper(root.left, sb);
        serializehelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0){
            return null;
        }
        String[] arr = data.split(splitter);
        int[] pos = new int[1];
        return deserialHelper(arr, pos, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode deserialHelper(String[] arr, int[] pos, int min, int max){
        if (pos[0] == arr.length){
            return null;
        }
        int val = Integer.valueOf(arr[pos[0]]);
        if (val < min || val > max){
            return null;
        }
        TreeNode node = new TreeNode(val);
        pos[0]++;
        node.left = deserialHelper(arr, pos, min, val);
        node.right = deserialHelper(arr, pos, val, max);
        return node;
    }