class Solution {
    public int maxProduct(int[] nums) {
        // Initialize
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        int len = nums.length;

        for(int i = 1; i < len; i ++){
           if (nums[i] < 0){
               //Swap
               int temp = currMax;
               currMax = currMin;
               currMin = temp;
           }
           // Update currMax and currMin.
               currMax = Math.max(currMax * nums[i], nums[i]);
               currMin = Math.min(currMin* nums[i], nums[i]);
            if(currMax > max){
                max = currMax;
            }
        }
        return max;
}
}
