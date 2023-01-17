class Solution {
    public int reverse(int x) {
        int ans = 0;
        int a = 0;
        while (x != 0){
            // Getting the last digit.
            a = x % 10;
            // Removing the last digit
            x = x / 10;
            // Outside the range.
            // MAX is 2147483647 and MIN is -2147483648
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE && a > 7)){
                return 0;
            }
            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE && a < -8)){
                return 0;
            }
            ans = ans * 10 + a;
        }
        return ans;
    }
}