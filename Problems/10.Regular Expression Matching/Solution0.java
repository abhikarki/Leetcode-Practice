class Solution0 {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }
        // If the next character is a star.
        if(p.length() > 1 && p.charAt(1) == '*'){
            if(isMatch(s, p.substring(2))){return true;}
            
            // If current characters match
            if(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
                return isMatch(s.substring(1), p);
            }
            return false;  
        }
        else{
        	// If current characters match, check the remaining characters.
            if(s.length()>0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
                return isMatch(s.substring(1),p.substring(1));
            }
        }
        return false;
    }
}