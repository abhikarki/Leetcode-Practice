class Solution {
    public void sortColors(int[] nums) {
        // Using three pointers.
        int len = nums.length;
        int i = 0;
        int j = 0;
        int k = len - 1;

        // Loop to perform the swaps.
        while (j <= k){
            if(nums[j] == 0){
                // No need of a temp variable to swap.
                nums[j] = nums[i];
                nums[i] = 0;
                j ++;
                i ++;
            }
            else if(nums[j] == 1){
                j ++;
            }
            else{
                nums[j] = nums[k];
                nums[k] = 2;
                k --;
            }
        }
      
        
    }
}