class Solution1 {
    public boolean isHappy(int n) {
        // Floyd's Tortoise and Hare Algorithm.
        // Use a slow pointer that finds the sum of squares of the number. At each 
        // step of the algorithm, the slow pointer moves one step whereas the
        // fast pointer moves twice as fast as slow pointer.
        // This algorithms helps to optimize the space complexity(unlike HashSet)
        int a = n;
        int b = n;
        do{
            // Slow pointer
            a = sum(a);
            // Fast Pointer
            b = sum(sum(b));

            if (b == 1){
                return true;
            }
        }while(a !=b );

        // If a == b, there's a cycle.
        return false;
    }

    public int sum(int num){
        int sum = 0;
        int digit = 0;
        // Calculate the sum of squares of digits.
        while(num > 0){
            digit = num % 10;
            sum += digit * digit;
            num = num/10;
        }
        return sum;
    }
}
