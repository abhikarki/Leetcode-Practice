// Solution with Sieve of Eratosthenes.
class Solution2 {
    public int countPrimes(int n) {
        if (n <= 2){
            return 0;
        }
        int count = 0;
        // Starting with '2' as counted already.
       if (n > 2){
            count = 1;
       }
       // initializing array
       boolean [] arr = new boolean [n];
       
       // Start with 3
       for (int i = 3; i < n; i += 2){
           if (!arr[i]){
               count ++;
               if (i > Math.sqrt(n)) continue;
               // Start with j = i as multiples of i below itself is already checked.
               for (int j = i; j * i < n; j ++ ){
                   arr[i * j] = true;
               }
           }     
       }
        return count;
    }
}