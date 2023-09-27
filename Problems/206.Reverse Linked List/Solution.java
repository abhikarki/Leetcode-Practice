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
    public ListNode reverseList(ListNode head) {
      // Return if head is null.
      if(head == null){
          return head;
      }
      ListNode temp = head.next;
      ListNode temp1 = null;
      head.next = null;
      // Go through the loop and swap the 'next' pointers.
      while(temp != null){
          temp1 = temp.next;
          temp.next = head;
          head = temp;
          temp = temp1;
      }
      // Return new head.
      return head;
    }
}