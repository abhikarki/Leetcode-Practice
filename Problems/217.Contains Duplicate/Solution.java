class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
         
         int len = nums.length;
        for (int i = 0; i < len; i ++){
            // If the set doesnot contain the number, add. Otherwise return true.
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }
            else{
                return true;
            }
        }
        // No duplicates
        return false;
    }
}