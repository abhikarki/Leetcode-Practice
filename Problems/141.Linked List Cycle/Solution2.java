public class Solution2 {
   public boolean hasCycle(ListNode head) {
       // Use a hashtable to store the nodes and check for repetition
       HashSet<ListNode> table = new HashSet<>();
       while(head != null){
           if(!table.contains(head)){
               table.add(head);
           }
           else{
               return true;
           }
           head = head.next;
       }
       return false;
   }
}