public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int M = board.length - 1;
        int N = board[0].length - 1;
        for (int i = 0; i <= M; i++){
            for (int j = 0; j <= N; j++){
                if (i == 0 || i == M || j == 0 || j == N){
                    if (board[i][j] == 'O'){
                        bfs(board, i, j);
                    }
                }
            }
        }
        for (int i = 0; i <= M; i++){
            for (int j = 0; j <= N; j++){
                if (board[i][j] == 'M'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void bfs(char[][] board, int i, int j){
        int M = board.length - 1;
        int N = board[0].length - 1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i);
        queue.offer(j);
        board[i][j] = 'M';
        while (!queue.isEmpty()){
            int row = queue.poll();
            int col = queue.poll();
            if (row + 1 <= M && board[row + 1][col] == 'O'){
                queue.offer(row + 1);
                queue.offer(col);
                board[row + 1][col] = 'M';
            }
            if (row - 1 >= 0 && board[row - 1][col] == 'O'){
                queue.offer(row - 1);
                queue.offer(col);
                board[row - 1][col] = 'M';
            }
            if (col + 1 <= N && board[row][col + 1] == 'O'){
                queue.offer(row);
                queue.offer(col + 1);
                board[row][col + 1] = 'M';
            }
            if (col - 1 >= 0 && board[row][col - 1] == 'O'){
                queue.offer(row);
                queue.offer(col - 1);
                board[row][col - 1] = 'M';
            }
        }
    }


    public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int M = board.length - 1;
        int N = board[0].length - 1;
        for (int i = 0; i <= M; i++){
            for (int j = 0; j <= N; j++){
                if (i == 0 || i == M || j == 0 || j == N){
                    if (board[i][j] == 'O'){
                        board[i][j] = 'M';
                        dfs(board, i, j);
                    }
                }
            }
        }
        for (int i = 0; i <= M; i++){
            for (int j = 0; j <= N; j++){
                if (board[i][j] == 'M'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j){
        int M = board.length - 1;
        int N = board[0].length - 1;
        /*avoid deep recursion
        like:
        OOOOOOOOOO
        XXXXXXXXXO
        OOOOOOOOOO
        OXXXXXXXXX
        OOOOOOOOOO
        XXXXXXXXXO
        OOOOOOOOOO
        OXXXXXXXXX
        OOOOOOOOOO
        XXXXXXXXXO

        so prefer BFS
        */
        if (i + 1 < M && board[i + 1][j] == 'O'){
            board[i + 1][j] = 'M';
            dfs(board, i + 1, j);
        }
        if (i - 1 > 0 && board[i - 1][j] == 'O'){
            board[i - 1][j] = 'M';
            dfs(board, i - 1, j);
        }
        if (j + 1 < N && board[i][j + 1] == 'O'){
            board[i][j + 1] = 'M';
            dfs(board, i, j + 1);
        }
        if (j - 1 > 0 && board[i][j - 1] == 'O'){
            board[i][j - 1] = 'M';
            dfs(board, i, j - 1);
        }
    }
}
}