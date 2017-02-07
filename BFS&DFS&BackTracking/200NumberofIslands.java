200. Number of Islands
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

private int n;
    private int m;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == '1'){
                    count++;
                    dfsHelper(grid, i, j);
                }
            }
        }
        return count;
    }
    public void dfsHelper(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfsHelper(grid, i + 1, j);
        dfsHelper(grid, i - 1, j);
        dfsHelper(grid, i, j + 1);
        dfsHelper(grid, i, j - 1);
    }