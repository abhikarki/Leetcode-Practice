class Solution2 {
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
            int ch = s.charAt(j) - 'A';
            arr[ch] ++;
            // Update the max occurring character in current window.
            // Here, you donot have to use a loop to calcuate the max because the
            // condition is window length - max >= k, so window length(our result) is
            // maximum when k + max is maximum that is 'max' is maximum. Once we find 
            // a 'max', the only condition our result is going to change is when we
            // find a character repeating more than the current 'max' times. The 
            // if condition below checks for that.
            if(arr[ch] > max){
                max = arr[ch];
            }
            int currLength = j - i + 1;
            // Move the left pointer.
            // Also, you can use an if condition instead of a while loop below because
            // it is only going to run at most 1 time. 
            while(currLength - max > k){
                arr[s.charAt(i) - 'A'] --;
                i++;
                currLength --;
            }
            if(currLength - max <= k){
                if(currLength > result){
                    result = currLength;
                }
            }
            j++;
        }
        return result;
    }
}