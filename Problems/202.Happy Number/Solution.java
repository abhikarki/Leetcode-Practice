class Solution {
    public boolean isHappy(int n) {
        // Create a HashSet to detect the repetition.(cycle detection)
        HashSet <Integer> nums = new HashSet<>();

        int sum = 0;
        int a = 0;
        while(n != 1){
            // Check if the number is repeated.
            if(nums.contains(n)){
                return false;
            }
            // Add the number to hashset.
            nums.add(n);
            sum = 0;
            // Calculate the sum of squares of the digits.
            while(n > 0){
                a = n % 10;
                sum = sum + (a * a);
                n = n/10;
            }
            n = sum;
        }

        return true;
    }
}