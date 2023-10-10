class Solution {
    public String minWindow(String s, String t) {
        int len = t.length();
        int strLen = s.length();

        // HashMap to store the frequency of characters in string 't'.
        HashMap <Character, Integer> map = new HashMap<>();
        // Count keeps track of the total unique characters to be matched.
        int count = 0;
        // Fill the hashmap with frequencies.
        for(int i = 0; i < len; i ++){
            char chr = t.charAt(i);
            if(!map.containsKey(chr)){
                map.put(chr, 1);
                count ++;
            }
            else{
                map.put(chr, map.get(chr) + 1);
            }
        }
        // Start - start index of the result substring.
        // resultLen - Length of the result substring.
        int start = 0;
        int resultLen = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        while(j < strLen){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0){
                    count --;
                }
            }
            //count== 0 i.e. all the characters have been matched in current substring.
            while(count == 0){
                char ch1 = s.charAt(i);
                if(map.containsKey(ch1)){
                    map.put(ch1, map.get(ch1) + 1);
                    if(map.get(ch1) > 0){
                        count ++;
                        // update the start index and length of the minimum substring.
                        if(j-i < resultLen){
                            start = i;
                            resultLen = j - i;
                        }
                        
                    }
                }
                i ++;
            }
            j++;
        }
        
        if(resultLen != Integer.MAX_VALUE){
            return s.substring(start, start + resultLen + 1);
        }
        else{
            return "";
        }
    }
}