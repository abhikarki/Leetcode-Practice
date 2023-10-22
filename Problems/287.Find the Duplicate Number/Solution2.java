class Solution2{
    public int findDuplicate(int[] nums) {
        // Floyd's cycle finding algorithm.
        // 2nd PHASE - WORKING--
        // O->O->O-------X-------->O->O->O
        //                         ^     | 
        //                         |     |
        //                         Z     Y
        //                         |     |
        //                         O<-O<-O
        // let the pointers meet at 'X + Y' th position. (X+Y) is the distance moved
        // by the slow pointer whereas the fast pointer moved X + a(Y+Z) + Y distance,
        // where (Y+Z) is the length of the cycle and 'a' is the number of rotations.
        // So, the number of steps of slow and fast pointer gives:
        //                   2(X + Y) = X + a(Y+Z) + Y
        //                =>       X  = a(Y+Z) - Y
        // So, in the second phase when the slow pointer starts at the '0' index and 
        // moves X steps, fast pointer starts at (X+Y)th position and moves a(Y+Z)-Y 
        // steps. The slow pointer ends at X th position and fast pointer also ends at 
        // X th position which is the start of the cycle. [fast pointer when moved
        // a(Y+Z) steps comes back to the same position and minus the Y gets it to the 
        // Xth position.]

        int len = nums.length;
        int slow = nums[0];
        int fast = nums[0];
        // First Phase - the fast pointer moves twice as fast as the slow pointer and 
        // eventually they point to the same node. 
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        slow = nums[0];
        // Second Phase - finding the start of the cycle.
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}