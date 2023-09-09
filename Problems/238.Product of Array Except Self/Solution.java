class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        // Creating two arrays: prefix product array and suffix product array.
        // prefixArr stores the product of numbers before the current element.
        // suffixArr stores the product of numbers after the current element.
        int [] prefixArr = new int [len];
        int [] suffixArr = new int [len];

        prefixArr[0] = 1;
        suffixArr[len-1] = 1;
        
        for (int i = 1; i < len; i ++){
            // prefix product = previous number * its prefix product
            prefixArr[i] = prefixArr[i-1] * nums[i-1];
        }

        for (int j = len - 2; j >=0; j --){
            // suffix product = next number * its suffix product
            suffixArr[j] = suffixArr[j+1] * nums[j+1]; 
        }

        int [] result = new int [len];
        for (int k = 0; k < len; k ++){
            result[k] = prefixArr[k] * suffixArr[k];
        }
        return result;
}
}

