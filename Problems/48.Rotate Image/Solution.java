class Solution {
    public void rotate(int[][] matrix) {
        // Rotate the elements 90 deg. clockwise one by one from the outer 
    	// layer. Move to the next inner layer and repeat the rotation.
        // Another approach is to rotate the diagonal by 90 deg. and then swap the
        // elements on the opposite sides of the diagonal(first swap the rows top to
        // bottom to rotate the diagonal and then swap the elements on the opposite
        // sides)

        //n = no. of rows = no. of columns
        int n = matrix.length;

        // We can use same values of start and end as it is a square matrix.
        int start = 0;
        int end = n-1;
 
        int temp = 0;
        int  i = 0;
        while(start <= end){
            i = 0;
            while(i < n -1){
                // Perform the swaps.
                temp = matrix[start + i][end];
                matrix[start + i][end] = matrix[start][start + i];
                matrix[start][start+ i] = matrix[end-i][start];
                matrix[end-i][start] = matrix[end][end-i];
                matrix[end][end-i] = temp;
                i ++;
            }
            // Update for next layer.
            n = n - 2;
            start++;
            end--;
        }
    
    }
}