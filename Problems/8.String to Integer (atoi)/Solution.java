class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        int c = 0;
        // Check for blank spaces.
        while(c < len && s.charAt(c) == ' '){
            c ++;
        }
        // d is used to compute the integer as positive or negative.
        int d = 1;
        // Check for positive of negative
        if (c < len){
            if (s.charAt(c) == '-'){
            // Change d to negative. This will help us to compute negative easily.
            d = -1;
            c++;
            }
            else if (s.charAt(c) == '+'){
            c++;
            }
        }
        int ans = 0;
        int diff = 0;
        while(c < len && check(s.charAt(c))){
            // Since, java allows to subtract the characters(returns the difference
            // between the ASCII values).
            diff = s.charAt(c) - '0';
            // Check for the range of the integer.
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && diff > 7)){
                return Integer.MAX_VALUE;
            }
            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && diff > 8)){
                return Integer.MIN_VALUE;
            }
            // Compute the number(we multiply by d(1 or -1) which decides whether
            // the number should be positive or negative.
            ans = ans * 10 + (diff * d);
            c++;
        }
         return ans;
    }

    /** Check if the character is a digit.
     */
    public boolean check (char cha){
        // Since, Java allows to compare the characters(compares the ASCII values.)
        if (cha >= '0' && cha <= '9'){
            return true;
        }
        return false;
    }
}