class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       // Sorting the array so that the duplicate element come together.
       Arrays.sort(nums);
       int len = nums.length;
       List<List<Integer>> result = new ArrayList<>();

       for (int i = 0; i < len; i ++){
           // Sum == 0 not possible in the sorted array if the 1st number is +ve.
           if (nums[i] > 0){
               return result;
           }
           // Check if the current element is equal to the previous.
           // If so, skip, to avoid the duplicates.
           if (i > 0 && nums[i] == nums[i - 1]){
               // Continue to the next iteration;
               continue;
           }

           int j = i + 1;
           int k = len - 1;
           int sum = 0;
           while(j < k){
               // Calculate the sum
               sum =nums[i] + nums[j] + nums[k];
               if (sum == 0){
                   // Add the list.
                   result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                   
                   // Update to avoid repetition.
                   while(j < k && nums[j] == nums[j+1]){
                       j ++;
                   }
                   while(j < k && nums[k] == nums[k-1]){
                       k --;
                   }
                   j ++;
                   k --;
               }
               else if(sum < 0){
                   j ++;
               }
               else{
                   k --;
               }
           }
       }
       return result;
    }
}