class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        // Result Array
        int [] arr = new int [len];

        // First, filling up the indices with prefix product.
        arr[0] = 1;
        for (int i = 1; i < len; i ++){
            arr[i] = arr[i-1] * nums[i-1];
        }

        // Now finding the suffix product for indices as multiplying it with 
        // the current value(prefix product)
        // We start at index (len-2) because for the last index the value equals
        // prefix product.
        int product = 1;
        for (int j = len - 2; j >=0; j --){
            // finding suffix product
            product = product * nums[j+1];
            // Updating the value
            arr[j] = arr[j] * product;
        }
        return arr;
        
}
}

