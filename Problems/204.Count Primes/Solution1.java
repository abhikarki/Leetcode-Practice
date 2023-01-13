class Solution1 {
    public int countPrimes(int n) {
       int count = 0;
       boolean add = true;
       for (int i = 2; i < n; i ++){
           add = true;
           if (i == 2 || i == 3){
               count ++;
        	   // Continue to the next iteration of the loop
               continue;
           }
           // Not prime if --
           if (i % 2 == 0 || i % 3 == 0){
               continue;
           }
           // Check till the square root of the number.
           // Every prime number greater than 3 can be expressed as 6k+1 or 6k-1.
            for (int j = 5; j * j <= i; j += 6){
                if(i % j == 0 || i % (j + 2) == 0){
                    add = false;
                    break;
                }
            }
            // Update the count.
            if (add == true){
                count ++;
            }
       }
       return count;       
    }
}