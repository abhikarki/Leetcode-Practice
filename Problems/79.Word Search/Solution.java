class Solution {

    public boolean exist(char[][] board, String word) {
      int len = board.length;
      int col = board[0].length;
      // Current index in the word.
      int curr = 0;
      // Begin searching with each cell.
      for(int i = 0; i < len; i ++){
          for (int j = 0; j < col; j ++){
             // For each cell, call the function to go through possible words.
             if (checkExistence(board, word, i, j, curr) == true){
                return true;
             }
        }
      }

      return false;
    }

    
    public boolean checkExistence(char[][] board, String word, int i, int j, int curr){
        // if the 'curr' is >= word's length, the word has been found.
        if(curr >= word.length()){
            return true;
        }
        // Store the current character in the board.
        char a = word.charAt(curr);
        // If we are within the bounds of the board, compare the characters.
        if(i >= 0&&i < board.length && j >=0 &&j < board[0].length && board[i][j]== a){
            // Change the cell to '0' to mark visited.
            board[i][j] = '0';
            // Recursive calls in all valid directions.
            if((checkExistence(board,word,i+1,j,curr+1) == true)||
              (checkExistence(board,word,i-1,j,curr+1) == true)||
              (checkExistence(board,word,i,j+1,curr+1) == true)||
              (checkExistence(board,word,i,j-1,curr+1) == true)){
                board[i][j] = a;
                return true;
            }
            // Change the value back to a.
            board[i][j] = a;

        }

        // Word not found in current path.
        return false;
    }
}