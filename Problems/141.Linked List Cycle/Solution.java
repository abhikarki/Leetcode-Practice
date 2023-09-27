/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        // Floyd' cycle-finding algorithm.
        // Use a slow and a fast pointer.
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // If slow pointer equals to fast pointer, there's a cycle.
            if(slow == fast){
                return true;
            }
        }
        // if fast pointer points to null, there's no cycle.
        return false;
    }
}