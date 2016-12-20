public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String a, String b) {
        // write your code here
        int asize = a.length();
        int bsize = b.length();
        int max = 0;
        int[][] dp = new int[asize + 1][bsize + 1];
        for (int i = 0; i < asize; i++){
            for (int j = 0; j < bsize; j++){
                if (a.charAt(i) == b.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max;
    }
}
