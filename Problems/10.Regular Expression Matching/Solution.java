// Dynamic programming.

class Solution {
    public boolean isMatch(String s, String p) {
       // Table of dimensions- length + 1. First row and column for empty string or
       // empty pattern 
       boolean table[][] = new boolean [s.length() +1][p.length() + 1];
       // When both are empty.
       table[0][0] = true;
       // Fill the first row.(when the string is empty.)
       for (int a = 2; a < p.length() + 1; a +=2 ){

           if(p.charAt(a-1) == '*'){
               table[0][a] = table[0][a-2];
           }
       }
       // Fill the rest of the rows
       for (int i = 1; i < s.length()+1; i ++){
           for (int j = 1; j < p.length()+1; j ++){
               // If the characters are same, check if the strings are equal till the
               // previous character i.e the cell is equal to [i-1][j-1].
               if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j -1) == '.'){
                   table[i][j] = table[i-1][j-1];
               }
            // If it is a '*', check if the strings can be matched without the 
            // character i.e. set true if [i][j-2] is true.
            // If not, check if the character matches with previous character and
            // also if the cell right above is true.(this means the pattern matches
            // string till previous character and '*' can match both current and prev.)
                if(p.charAt(j-1) == '*'){
                    if (table[i][j-2] == true){
                        table[i][j] = true;
                    }
                    if ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && table[i-1][j] == true){
                        table[i][j] = true;
                    }
                }
           }
       }
       // The last cell of our table stores the return value. 
       return table[s.length()][p.length()];
}
}