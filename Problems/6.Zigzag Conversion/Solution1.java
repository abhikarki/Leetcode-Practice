class Solution1 {
    public String convert(String s, int numRows) {
      int len = s.length();
      // Base cases
      if (len == 1 || numRows == 1){
          return s;
      }
      // Create StringBuilder array to contain strings corresponding to rows.
      StringBuilder [] arr = new StringBuilder[numRows];
      // Initialise the strings in arr.
      for (int x = 0; x < numRows; x ++){
          arr[x] = new StringBuilder("");
      }
      	// boolean to keep track of direction.
        boolean up = true;
        int n = numRows - 1;
        int a = 0;
        for(int i = 0; i < len; i ++){
          arr[a].append(s.charAt(i));
          if (a == 0){
              up = true;
          }
          if (a == n){
              up = false;
          }
          if (up == true){
              a ++;
          }
          if (up == false){
              a --;
          }
      }
        // Create the final string.
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < numRows; j ++){
            result.append(arr[j]);
        }
        return result.toString();
        }
}