class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       int len = intervals.length;

       List <int []> result = new ArrayList<>();

       int i = 0;
       // Add all the non overlapping arrays in the beginning
       while (i < len && newInterval[0] > intervals[i][1]){
               result.add(intervals[i]);
               i++;
       }
        
       // Merge the overlapping intervals 
       while(i < len && newInterval[1] >=intervals[i][0]){
               newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
               newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
               i ++;
       }
       // Add the merged interval
       result.add(newInterval);

       // Add the rest of the intervals.
       while(i < len){
           result.add(intervals[i]);
           i ++;
       }

       return result.toArray(new int[result.size()][]);
       
    }
}