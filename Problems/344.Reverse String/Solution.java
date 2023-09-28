class Solution {
    public void reverseString(char[] s) {
        // use two pointers at two ends of the array.
        int len = s.length;
        int i = 0;
        int j = len -1;
        
        // Swap the characters and update the pointers.
        while(i < j){
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i ++;
            j --;
        }
    }
}