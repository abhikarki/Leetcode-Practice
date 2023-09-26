class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the 2D array using a comparator defined with a lambda expression.
       Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
       int len = intervals.length;
       // A list to store the merged elements.
       List <int []> result = new ArrayList<>();

       //Here, we define a newInterval array to keep track of the current overlapping
       //arrays. We then add the array to the result list. Inside the loop, when we
       //update the newInterval array, the values are also directly updated in the
       //array in the list.
       int [] newInterval = intervals[0];
       result.add(newInterval);
       
       for(int i = 0; i < len; i ++){
           // Check for the overlap.
           if(newInterval[1] >= intervals[i][0]){
               newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
           }
           else{
               //As the newInterval is being updated directly on the list, we
               //can set it to the next element of intervals and add it to the list.
               newInterval = intervals[i];
               result.add(newInterval);

           }
       } 
       //Return the array.
       return result.toArray(new int[result.size()][]);
    } 
}