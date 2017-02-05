286. Walls and Gates

/*

ou are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

  */

public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[i].length; j++){
                if (rooms[i][j] == 0){
                    helper(rooms, i, j, 0);
                }
            }
        }
    }
    
    public void helper(int[][] rooms, int i, int j, int d){
        if (i >= rooms.length || i < 0 || j >= rooms[i].length || j < 0){
            return;
        }
        if (rooms[i][j] < d){
            return;
        }
        rooms[i][j] = d;
        helper(rooms, i + 1, j, d + 1);
        helper(rooms, i - 1, j, d + 1);
        helper(rooms, i, j + 1, d + 1);
        helper(rooms, i, j - 1, d + 1);
    }

public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[i].length; j++){
                if (rooms[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            while (size > 0){
                int[] cur = queue.poll();
                size--;
                int row = cur[0], col = cur[1];
                if (row > 0 && rooms[row - 1][col] > count){
                    rooms[row - 1][col] = count;
                    queue.offer(new int[]{row - 1, col});
                }
                if (col > 0 && rooms[row][col - 1] > count){
                    rooms[row][col - 1] = count;
                    queue.offer(new int[]{row, col - 1});
                }
                if (row < rooms.length - 1 && rooms[row + 1][col] > count){
                    rooms[row + 1][col] = count;
                    queue.offer(new int[]{row + 1, col});
                }
                if (col < rooms[0].length - 1 && rooms[row][col + 1] > count){
                    rooms[row][col + 1] = count;
                    queue.offer(new int[]{row, col + 1});
                }
            }
            
        }
    }