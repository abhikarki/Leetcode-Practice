class Solution2 {
    public String convert(String s, int numRows) {
      int len = s.length();
      if (len <= 1 || numRows == 1){
          return s;
      }
      StringBuilder result = new StringBuilder("");
      // increment pattern
      int x = 2 * (numRows - 1);
      for (int i = 0; i < numRows; i ++){
          for (int j = i; j < len; j += x){
              result.append(s.charAt(j));
              // Rows excluding first and last have another increment pattern too.
              if (i != 0 && i != (numRows - 1) && (j + x - 2 * i) < len){
                  result.append(s.charAt(j + x - 2 * i));
              }
          }
      }
      return result.toString();
        }
}