class Solution2 {
    public boolean isPalindrome(String s) {
        
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j){
            char a = s.charAt(i);
            char b = s.charAt(j);

            // Skip to next character if the character is not alphanumeric.
            if(a < 48 || (a > 57 && a < 65) || (a > 90 && a < 97) || a > 122){
                // Next character.
                i ++;
                continue;
            }

            if(b < 48 || (b > 57 && b < 65) || (b > 90 && b < 97) || b > 122){
                // Next character.
                j --;
                continue;
            }

            // Convert to lowercase.
            if(a >= 65 && a <= 90){
                a += 32;
            }
            if(b >= 65 && b <= 90){
                b += 32;
            }
            // Compare
            if(a == b){
                i ++;
                j --;
            }
            else{
                return false;
            }
        }

        return true;
    }
}