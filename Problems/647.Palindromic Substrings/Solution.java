class Solution {
    // Count of palindromic substrings.
    int count = 0;
    public int countSubstrings(String s) {
        int len = s.length();

        for(int i = 0; i < len; i ++){
            // update count for the single length palindrome.
            count ++;
           //Compute the palindrome & update the count for odd & even length palindrome
            compute(i-1, i+1, s, len);
            compute(i, i+1, s, len);
        }
        return count;
    }

    public void compute(int a, int b, String s, int len){
        while(a>=0 && b < len && s.charAt(a) == s.charAt(b)){
            count ++;
            a--;
            b++;
        }
    }
}

