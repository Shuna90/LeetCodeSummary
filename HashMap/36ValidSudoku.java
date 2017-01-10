36. Valid Sudoku
public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            Set<Character> rows = new HashSet<Character>();
            Set<Character> colomns = new HashSet<Character>();
            Set<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.' && !rows.add(board[i][j])){
                    return false;
                }
                if (board[j][i] != '.' && !colomns.add(board[j][i])){
                    return false;
                }
                int cubeI = 3 * (i / 3);
                int cubeJ = 3 * (i % 3);
                if (board[cubeI + j / 3][cubeJ + j % 3] != '.' && !cube.add(board[cubeI + j / 3][cubeJ + j % 3])){
                    return false;
                }
            }
        }
        return true;
    }