public class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        NumMatrixUtil(matrix);
    }
    public void NumMatrixUtil(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        dp = new int[matrix.length][matrix[0].length + 1];
        dp[0][0] = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 1; j <= matrix[0].length; j++){
                dp[i][j] = dp[i][j - 1] + matrix[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp == null || dp.length == 0 || dp[0].length == 0){
            return 0;
        }
        int sum = 0;
        for (int i = row1; i <= row2; i++){
            sum += dp[i][col2 + 1] - dp[i][col1];
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);