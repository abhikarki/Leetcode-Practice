class Solution {
    public boolean isPalindrome(String s) {
        
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j){
            char a = s.charAt(i);
            char b = s.charAt(j);

            // Compare if the characters are letters or digits.
            if(Character.isLetterOrDigit(a) && Character.isLetterOrDigit(b)){
                if(Character.toLowerCase(a) == Character.toLowerCase(b)){
                    i ++;
                    j --;
                }
                else{
                    return false;
                }
            }
            else if(!Character.isLetterOrDigit(a)){
                i ++;
            }
            else if(!Character.isLetterOrDigit(b)){
                j --;
            }
        }

        // End of the loop reached, return true.
        return true;
    }
}