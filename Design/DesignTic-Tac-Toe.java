public class TicTacToe {
    public int[] row;
    public int[] col;
    int dia;
    int anti_dia;
    int size;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        row = new int[n];
        col = new int[n];
        size = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int a, int b, int player) {
        int add = player == 1 ? 1 : -1;
        row[a] += add;
        col[b] += add;
        if (a + b == size - 1){
            anti_dia += add;
        }
        if (a == b){
            dia += add;
        }
        
        if (Math.abs(row[a]) == size || Math.abs(col[b]) == size || Math.abs(dia) == size || Math.abs(anti_dia) == size){
            return player;
        }
        return 0;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */