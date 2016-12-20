public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            if (matrix[i][0] == '1'){
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int j = n - 1; j >= 0; j--){
            max = Math.max(max, calculate(stack, dp, j));
        }
        return max;
    }
    public int calculate(Stack<Integer> stack, int[][] dp, int j){
        int i = 0;
        int res = 0;
        while (i < dp.length){
            while (!stack.isEmpty() && dp[i][j] <= dp[stack.peek()][j]){
                int index = stack.pop();
                int width = stack.isEmpty() ? i : (i - 1 - stack.peek());
                res = Math.max(res, width * dp[index][j]);
            }
            stack.push(i);
            i++;
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            int width = stack.isEmpty() ? i : (i - 1 - stack.peek());
            res = Math.max(res, width * dp[index][j]);
        }
        return res;
    }
    
}