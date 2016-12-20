public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        if (word == null || word.length() == 0){
            return true;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0) && check(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean check(char[][] board, String word, int i, int j, int index, boolean[][] visited){
	   if (index == word.length() - 1){
	       return true;
	   }
        boolean res = false;
        visited[i][j] = true;
        char s = word.charAt(index + 1);
        if (i + 1 < board.length && !visited[i + 1][j] && s == board[i + 1][j]){
            res |= check(board, word, i + 1, j, index + 1, visited);
        }
        if (i - 1 >= 0 && !visited[i - 1][j] && s == board[i - 1][j]){
            res |= check(board, word, i - 1, j, index + 1, visited);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && s == board[i][j - 1]){
            res |= check(board, word, i, j - 1, index + 1, visited);
        }
        if (j + 1 < board[0].length && !visited[i][j + 1] && s == board[i][j + 1]){
            res |= check(board, word, i, j + 1, index + 1, visited);
        }
        if (!res){
            visited[i][j] = false;
        }
        return res;
    }
}