class Solution {
    public void gameOfLife(int[][] board) {
        
        // In this Approach, '10' represents current dead cell turned live
        // And '01' represents current live cell turned dead.
        // '00' represents current dead turned dead
        // '11' represents current live and stayed live

        // Number of Rows
        int m = board.length;
        // Number of columns.
        int n = board[0].length;

        // Arrays to check neighbor cells
        int [] p = {-1, -1, -1, 0, 0, 1, 1, 1};
        int [] q = {-1, 0, 1, -1, 1, -1, 0, 1};

        // To could the live neighbor cells.
        int liveCount = 0;

        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                liveCount = 0;
                
                // check the neighbor cells to update liveCount
                for (int k = 0; k < 8; k++) {
                    int x = i + p[k];
                    int y = j + q[k];

                    if (x >= 0 && x < m && y >= 0 && y < n && (x != i || y != j)) {
                        // Update the liveCount by bitwise operation.
                        // The following bitwise AND operation gives 1 if the current
                        // state is live
                        liveCount += board[x][y] & 1;
                    }
                }

                // Update the cells
                // for live cells that turn to live update value to 3(11),
                // for dead cells that turn to live update value to 2(10),
                // for the cells that turn from live to dead (01) and dead to dead
                // (00), they are already in the correct states
                if (board[i][j] == 1 ){
                    if(liveCount == 2 || liveCount == 3){
                        board[i][j] = 3;
                    }   
                }
                if(board[i][j] == 0 && liveCount == 3){
                    board[i][j] = 2;
                }
            }
        }

        // Update the board.
        for (int a = 0; a < m; a ++){
            for (int b =0; b <n; b++){
                // The second least significant bit contains the next state.
                //So, shifting the bit towards right by one bit and assigning it back
               board[a][b] >>= 1;
            }
        }
        System.out.println(board);
    }
}

