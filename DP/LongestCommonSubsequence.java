public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int sizeA = A.length();
        int sizeB = B.length();
        int[][] dp = new int[sizeA + 1][sizeB + 1];
        for (int i = 0; i < sizeA; i++){
            for (int j = 0; j < sizeB; j++){
                if (A.charAt(i) == B.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[sizeA][sizeB];
    }
}
