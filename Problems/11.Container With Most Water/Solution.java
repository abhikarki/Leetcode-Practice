class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        // Two pointers have been set at the two ends of the array.
        // At each step the area is calculated. Then the pointer with 
        // lower height is moved one step because either the current step
        // gives the max area or the next step with comparatively greater 
        // lower height gives the max area. The greater lower height can
        // be current higher value or a value greater than current
        // low but lesser than current high. Repeat this
        while (i != j){
            if (height[i] >= height[j]){
                area = height[j] * (j - i);
                j -= 1;
            }
            else{
                area = height[i] * (j - i);
                i += 1;
            }
            if (area > max){
                max = area;
            }
        }
        return max;
    }
}