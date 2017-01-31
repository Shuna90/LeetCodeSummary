260. Single Number III

/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/
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