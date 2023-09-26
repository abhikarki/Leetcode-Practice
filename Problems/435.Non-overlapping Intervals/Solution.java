class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       // Go through the array with two pointers. Compare to check if they overlap.
       // If they overlap, move the pointers representing the deletion of interval
       // with higher end value. This decreases the chance that there are more 
       // overlaps.

       // Sort the array
       Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
       int len = intervals.length;
       int i = 0;
       int j = 1;
       int count = 0;
       while(j < len){
           if(intervals[i][1] > intervals[j][0]){
               count ++;
               //update i and j
               if(intervals[i][1] > intervals[j][1]){
                   i = j;
                   j++;
               }
               else{
                   j ++;
               }
           }
           // If there's no overlapping, just update the variables.
           else{
               i = j;
               j ++;
           }
       }
       return count;
    }
}