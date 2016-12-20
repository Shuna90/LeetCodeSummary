public class Solution {
    public int[] singleNumber(int[] nums) {
        int XOR = 0;
        for (int i = 0; i < nums.length; i++){
            XOR ^= nums[i];
        }
        int mask = XOR & (~(XOR - 1));
        /*
        for (int i= 0; i < 32; i++){
            if (((XOR >> i) & 1) == 1){
                mask = 1 << i;
                break;
            }
        }
        */
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            if ((nums[i] & mask) == 0){
                res[0] ^= nums[i];
            }else{
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}