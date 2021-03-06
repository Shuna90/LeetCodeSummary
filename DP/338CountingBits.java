338. Counting Bits
/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
Hint:

You should make use of what you have produced already.
Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
Or does the odd/even status of the number help you in calculating the number of 1s?

*/
public class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int offset = 1;
        for (int i = 1; i <= num; i++){
            if (offset * 2 == i){
                offset *= 2;
            }
            dp[i] = dp[i - offset] + 1;
        }
        return dp;
    }

    public int[] countBits(int num) {
        if (num <= 0){
            return new int[]{0};
        }
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (num == 1){
            return dp;
        }
        for (int i = 1; i < 32; i++){
            int pre = 1 << (i - 1);
            int start = 1 << i;
            int end = 1 << (i + 1);
            dp[start] = 1;
            for (int j = start + 1; j < end && j <= num; j++){
                dp[j] = dp[start] + dp[j - start];
            }
            if (dp[num] != 0){
                break;
            }
        }
        return dp;
    }
}