public class NumArray {
    public class SegmentNode{
        int start;
        int end;
        int sum;
        SegmentNode left;
        SegmentNode right;
        public SegmentNode(int start, int end){
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            sum = 0;
        }
    }
    SegmentNode root;
    public NumArray(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }
    
    public SegmentNode buildSegmentTree(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        SegmentNode node = new SegmentNode(start, end);
        if (start == end){
            node.sum = nums[start];
        }else{
            int mid = start + (end - start) / 2;
            SegmentNode left = buildSegmentTree(nums, start, mid);
            SegmentNode right = buildSegmentTree(nums, mid + 1, end);
            node.left = left;
            node.right = right;
            node.sum = left.sum + right.sum;
        }
        return node;
    }
    
    void update(int i, int val) {
        updateTree(i, val, root);
    }
    
    public void updateTree(int i, int val, SegmentNode node){
        if (node == null || i < node.start || i > node.end){
            return;
        }
        if (node.start == i && node.end == i){
            node.sum = val;
        }else{
            updateTree(i, val, node.right);
            updateTree(i, val, node.left);
            node.sum = node.left.sum + node.right.sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return getSum(root, i, j);
    }
    public int getSum(SegmentNode node, int i, int j){
        if (node == null || node.start > j || node.end < i){
            return 0;
        }
        if (i <= node.start && j >= node.end){
            return node.sum;
        }
        int left = getSum(node.left, i, j);
        int right = getSum(node.right, i, j);
        return left + right;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);