class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder st = new StringBuilder("");
        int min = strs[0].length();
        int len = strs.length;
        // First finding the length of the shortest string.
        for(int i = 0; i < len; i ++){
            if (strs[i].length() < min){
                min = strs[i].length();
            }
        }
        // Go through each character and match with the first string.
        for (int j = 0; j < min; j ++){
            int b = 1;
            // Current character.
            char a = strs[0].charAt(j);
            while(b < len){
                if (strs[b].charAt(j) != a){
                	// Return the string if a character does not match.
                   return st.toString(); 
                }
                b ++;
            }
            // Current character matches to all the strings, so append.
            st.append(a);
        }
        return st.toString();
    }
}