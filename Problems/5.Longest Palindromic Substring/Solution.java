class Solution {
    int max = 0;
    int start = 0;
    public String longestPalindrome(String s) {
        int len = s.length();
        int i = 0;
        while (i < len){
            // Call the function to compute longest palindrome for odd and even length/
            compute(i-1, i+1, s, len);
            compute(i, i+1, s, len);
        i ++;
        }
        return s.substring(start, start + max);
    }

    public void compute(int a, int b, String s, int len){
        // Compute the palindrome by adding characters on both sides.
        while (a >= 0 && b < len && s.charAt(a) == s.charAt(b)){
                a--;
                b++;
            }
            // Update max and start
            if(b - a -1 > max){
                max = b - a - 1;
                start = a + 1;
            }
    }
}