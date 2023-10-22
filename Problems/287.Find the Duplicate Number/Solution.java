class Solution{
    public int findDuplicate(int[] nums) {
      int len = nums.length;
      int i = 0;
      // Sorting based on the indices.
      // If the current element is equal to index + 1, move to next element. Else,
      // swap the element to nums[element-1] until the current index is sorted.
      while(i < len){
          int a = nums[i];
          // Move to next if sorted.
          if(i == a - 1){
              i++;
          }
          // sort
          else{
            int temp = nums[a - 1];
            // If the index already contains correct element, duplicate found.
              if(a == temp){
                  return a;
              }
              nums[a-1] = a;
              nums[i] = temp;
          }
      }
      return 0;
    }
}