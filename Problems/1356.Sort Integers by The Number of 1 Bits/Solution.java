class Solution {
    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        // 2D array to store the decimal number and corresponding bitCount.
        int [][] newArr = new int [len][2];

        // Fill the 2D array.
        for (int i = 0; i < len; i ++){
            newArr[i][0] = arr[i];
            newArr[i][1] = Integer.bitCount(arr[i]);
        }

        // Comparator for sorting
        Comparator<int[]> comp = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1] > b[1]){
                    return 1;
                }
                if(a[1] == b[1]){
                    if (a[0] > b[0]){
                        return 1;
                    }
                }
                return -1;
            }
        };
        // Sorting based on the conditions.
        Arrays.sort(newArr, comp);

        // Update the array.
        for(int i = 0; i < len; i ++){
            arr[i] = newArr[i][0];
        }
        return arr;
    }
}
