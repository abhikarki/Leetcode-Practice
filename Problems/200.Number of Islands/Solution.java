class Solution {
    // Dimensions of the grid.
    int row = 0;
    int col = 0;

    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        // Count of islands.
        int count = 0;
        // Go through the grid. For each cell, if the value is '1' (land),
        // visit the neighbor cells.
        for(int i = 0; i < row; i ++ ){
            for (int j = 0; j < col; j ++){
                // visit the neighbors if it is a land.
                if(grid[i][j] == '1'){
                    // visit the neighbors through DFS.
                    visit(i,j,grid);
                    // Increment the count, as finding a '1' implies 
                    // that an island is found.
                    count ++;
                }
            }
        }
        return count;
    }

    // Depth-first search (DFS) 
    public void visit(int i, int j, char[][]grid){
        if(i >= row || j >= col || i < 0 || j < 0){
            return;
        }
        // If the value is not '1'(land), it is either '0' (water), or
        // '2' (visited land), so return.
        if(grid[i][j] != '1'){
            return;
        }
        // else if value is '1'(land), mark it as a visited land and visit
        // the neighbors.
        grid[i][j] = '2';
        visit(i+1, j, grid);
        visit(i, j+1, grid);
        visit(i-1, j,grid);
        visit(i, j-1, grid);
        }
        
    }
