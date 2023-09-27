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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // The result node.
        ListNode result = new ListNode();
        // head pointer to go through the result list
        ListNode head = result;

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while(temp1 != null && temp2 != null){
            // Compare and add the node to result.
            if(temp1.val <= temp2.val){
                head.next = temp1;
                temp1 = temp1.next;
            }
            else if(temp1.val > temp2.val){
                head.next = temp2;
                temp2 = temp2.next;
            }
            // Update head pointer.
            head = head.next;
        }
        
        // Fill the remaining.
        while(temp1 != null){
            head.next = temp1;
            temp1 = temp1.next;
            head = head.next;
        }
        while(temp2 != null){
            head.next = temp2;
            temp2 = temp2.next;
            head = head.next;
        }
    // Return the merged list.
    return result.next;
}
}

