class Solution2 {
    public String longestPalindrome(String s) {
        int len = s.length();

        // compArr[i][j] == 1 if substring(i, j+1) is a palindrome
        // compArr[i][j] == 0 if substring(i, j+1) is not a palindrome
        int [][] compArr = new int [len][len];
        int max = 0;
        int a = 0;
        int b = 0;

        int i = 0;
        int j = 0;
        while(i < len){
            j = 0;
            while(j < len && j + i < len){
                if(j == (j + i)
                   || (i == 1 && s.charAt(j) == s.charAt(j+i))
                   || (s.charAt(j) == s.charAt(j+i) && compArr[j+1][j+i-1] == 1))
                   {
                    compArr[j][j+i] = 1;
                    if(i >= max){
                        max = i;
                        a = j;
                        b = j + i;
                    }
                }
                j ++;
            }
            i ++;
        }
        return s.substring(a,b+1);
    }
}