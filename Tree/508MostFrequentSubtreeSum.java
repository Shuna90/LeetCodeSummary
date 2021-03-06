508. Most Frequent Subtree Sum

/*

Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

*/
int max = 0;
    Map<Integer, Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null){
            return new int[0];
        } 
        ArrayList<Integer> list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        traverse(root);
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            if (m.getValue() == max){
                list.add(m.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    public int traverse(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        int sum = left + right + root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        max = Math.max(max, count);
        return sum;
    }