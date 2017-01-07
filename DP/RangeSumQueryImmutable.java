303. Range Sum Query - Immutable
public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);