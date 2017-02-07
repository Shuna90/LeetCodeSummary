48. Rotate Image
/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int n = matrix.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                res[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = res[i][j];
            }
        }
    }