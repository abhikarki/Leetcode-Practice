class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int mid = 0;

        while(l <= r){
            mid = (l+r)/2;
            // return mid if it is the target element.
            if (nums[mid] == target){
                return mid;
            }
            // In a rotated sorted array, one half is sorted and the other 1/2 is not
            // So, we check which half is sorted and compare the target to see if the
            // target lies in the sorted half. If not, we nove to the other half.
            
            // Check if right half is sorted.
            else if(nums[r] >= nums[mid]){
                if (target >= nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
            // Check if left half is sorted.
            else if(nums[l] <= nums[mid]){
                if (target >= nums[l] && target <= nums[mid]){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}