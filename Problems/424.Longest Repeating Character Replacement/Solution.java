class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        // Array to keep track of frequency.
        int [] arr = new int [26];

        int i = 0;
        int j = 0;
        int max = 0;
        int result = 0;
        // Keep a sliding window with the window length - max >= k.
        while(j < len){
            arr[s.charAt(j) - 'A'] ++;
            // Update the max occurring character in current window.
            for(int a = 0; a < 26; a ++){
                if(arr[a] > max){
                    max = arr[a];
                }
            }
            int currLength = j - i + 1;
            // Move the left pointer.
            while(currLength - max > k){
                arr[s.charAt(i) - 'A'] --;
               for(int l = 0; l < 26; l ++){
                if(arr[l] > max){
                    max = arr[l];
                }
            }
                i++;
                currLength --;
            }
            if(currLength - max <= k){
                result = currLength;
            }
            j++;
        }
        return result;
    }
}