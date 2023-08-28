class Solution1 {
    public int removeDuplicates(int[] nums) {
      int len = nums.length;
      int i = 0;
      while (i < len){
          int a = nums[i];
          int b = 0;
          for (int j = i + 1; j < len; j ++){
              if (nums[j] == a){
                  b ++;
                  // Continue to the next iteration.
                  continue;
              }
              // Break the loop.
              break;
          }
          if (b >= 1){
              // Move the elements of the array forward.
              for (int x = i + b + 1; x < len; x ++){
                  nums[x - b + 1] = nums[x];
              }
              i =  i + 2;
              // Resize the len so that we donot re-run the loop till the actual end
              // of the array.
              len = len - b + 1;
            // Continue to the next iteration as the 'i' and 'len' have been changed.
              continue;
          }
          // if the current element in 'i'th position doesnot repeat, just start
          // checking from the next position.
          i = i + 1;
      }
      // Return the length (the number of elements in the array.)
      return len;

    }
}