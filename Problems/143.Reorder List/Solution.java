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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        // Find the middle of the list and reverse the second half.
        // Using slow and fast pointer to find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow points to the middle.
        // Reverse the second Half starting right after the slow pointer.
        // Use pointers to point the end of the first and second half to null.
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode temp1 = secondHalf.next;
        secondHalf.next = null;
        ListNode temp2 = null;

        // Reverse the second half.
        while(temp1 != null){
            temp2 = temp1.next;
            temp1.next = secondHalf;
            secondHalf = temp1;
            temp1 = temp2;
        }
        
        ListNode nextFirst = null;
        ListNode nextSecond = null;

        // Merge the two halves.
        while(head != null && secondHalf != null){
            nextFirst = head.next;
            nextSecond = secondHalf.next;

            head.next = secondHalf;
            secondHalf.next = nextFirst;

            head = nextFirst;
            secondHalf = nextSecond;
        }
    }
}

