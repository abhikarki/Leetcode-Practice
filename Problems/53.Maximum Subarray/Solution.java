class Solution {
    public int maxSubArray(int[] nums) {
        // Using Kadane's Algorithm
        // The currSum tracks the current sum. When currSum < 0, we set
        // it back to 0 while moving forward. This is because if we carry the
        // negative currSum, it is only going to decrease the upcoming subarray's
        // sum by the amount.

       int currSum = 0;
       // nums has atleast one item as per the description.
       int currMax = nums[0];

       int len = nums.length;

       for (int i = 0; i < len; i ++){
           currSum += nums[i];
           if (currSum > currMax){
               currMax = currSum;
           }
           if (currSum < 0){
               currSum = 0;
           }
       }
       // Return the maximum sum.
       return currMax;
}
}