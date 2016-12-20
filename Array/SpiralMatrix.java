public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int min = Math.min((row - 1)/ 2, (col - 1)/ 2);
        for (int round = 0; round <= min; round++){
            for (int i = round; i < col - round; i++){
                res.add(matrix[round][i]);
            }
            for (int i = round + 1; i <= row - round - 1; i++){
                res.add(matrix[i][col - 1 - round]);
            }
            for (int i = col - 2 - round; i >= round; i--){
                res.add(matrix[row - 1 - round][i]);
            }
            for (int i = row - 2 - round; i > round; i--){
                res.add(matrix[i][round]);
            }
        }
        int num = col * row;
        while (res.size() > num){
            res.remove(res.size() - 1);
        }
        return res;
    }
}