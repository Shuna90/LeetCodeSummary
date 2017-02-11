73. Set Matrix Zeroes

/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

public void setZeroes(int[][] matrix) {
        int col0 = 1, row0 = 1, n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++){
            if (matrix[i][0] == 0){
                col0 = 0;
            }
        }
        for (int j = 0; j < m; j++){
            if (matrix[0][j] == 0){
                row0 = 0;
            }
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n && col0 == 0; i++){
            matrix[i][0] = 0;
        }
        for (int j = 0; j < m && row0 == 0; j++){
            matrix[0][j] = 0;
        }
    }