class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Using hashmap to store the number and its index as (key,value) pair.
        // Before we insert each number, we check if the hashmap has the key of
        // (target - current number). If found we return an array of the indices.
        HashMap <Integer, Integer> map = new HashMap<>();
        
        int len = nums.length;
        for (int i = 0; i < len; i ++){
            // Check for the number
            if (map.containsKey((target - nums[i]))){
                // Return the result array.
                return new int [] {map.get(target - nums[i]), i};
            }
            else{
                map.put(nums[i], i);
            }
        }
        // Return empty array.
        return new int [0];
    }
}