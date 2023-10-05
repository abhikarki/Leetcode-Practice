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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        // oddPointer and evenPointer to point on odd and even position node.
        ListNode oddPointer = head;
        // Head of the even nodes.
        ListNode secondNode = head.next;
        ListNode evenPointer = head.next;

        while (evenPointer != null && evenPointer.next != null){
            oddPointer.next = oddPointer.next.next;
            evenPointer.next = evenPointer.next.next;
            oddPointer = oddPointer.next;
            evenPointer = evenPointer.next;
        }
        // Point to the even nodes' head.
        oddPointer.next = secondNode;
        
        return head;
    }
}

