public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < nums.length; i++){
            two |= one & nums[i];
            one ^= nums[i];
            three = two & one;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            int sum = 0;
            for (int j = 0; j < nums.length; j++){
                if (((nums[j] >> i) & 1) == 1){
                    sum++;
                    sum %= 3;
                }
            }
            if (sum != 0){
                res |= 1 << i;
            }
        }
        return res;
    }
}