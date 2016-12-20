public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        int height = triangle.size();
        List<Integer> last = triangle.get(height - 1);
        if (last.size() == 0){
            return 0;
        }
        int size = last.size();
        int[][] dp = new int[height][size];
        for (int i = 0; i < size; i++){
            dp[height - 1][i] = last.get(i);
        }
        for (int i = height - 2; i >= 0; i--){
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + list.get(j);
            }
        }
        return dp[0][0];
    }
}