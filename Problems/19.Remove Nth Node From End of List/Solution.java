/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // We take two pointers, 'slow' and 'fast'. Then, we move the fast pointer n+1
        // steps. When the fast pointer points to null, the slow pointer is pointing 
        // to the node just before the node to be removed. If n equals length of the 
        // list, we remove the head.
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        // Move the fast pointer n + 1 steps.
        for( i = 0; i <= n; i ++){
            if(fast == null){
                break;
            }
            else{
                fast = fast.next;
            }
        }
        // If n equals to the length of the list, remove the head.
        if(fast == null && i == n){
            head = head.next;
            return head;
        }
        // Move the fast and slow pointers.
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        } 
        // slow pointer is pointing just before the node to be removed.   
        slow.next = slow.next.next;    

        return head;
    }
}