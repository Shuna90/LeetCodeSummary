public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[][] dp = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++){
            dp[i][0] = true;
        }
        for (int i = 1; i <= A.length; i++){
            for (int j = 1; j <= m; j++){
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]]){
                    dp[i][j] = true;
                }
            }
        }
        for (int i = m; i >= 0; i--){
            if (dp[A.length][i]){
                return i;
            }
        }
        return 0;
    }
}
