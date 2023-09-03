class Solution2 {
    public int removeDuplicates(int[] nums) {
      int len = nums.length;
      // The 'index' variable keeps track of the current index of the array to be  
      // filled. We start as 2 as first 2 numbers are guaranteed to not have 
      // duplicates.
      int index = 2;
      
      // The 'i' runs through loop to check what element should be filled in the
      // 'index' position such that there are no duplicates.
      for (int i = 2; i < len; i ++){
          if (nums[i] != nums[index - 2]){
              nums[index] = nums[i];
              index ++;
          }
      }
      // index also keeps track of the length of the output array.
      return index;
    }
}