/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution2{
    public List<Integer> preorderTraversal(TreeNode root){

        TreeNode curr = root;
        List <Integer> result = new ArrayList <Integer>();
        // Use a stack to keep track of nodes.
        Stack <TreeNode> nodeStack = new Stack<>();
        if(curr == null){
            return result;
        }
        
        while(!nodeStack.isEmpty() || curr != null){
            while(curr != null){
                // When we encounter a node, we first add it to the list and then 
                // traverse its leaves.
                result.add(curr.val);
                nodeStack.push(curr);
                curr = curr.left;
            }
            // pop the node from stack. The top of the stack represents a node which
            // has itself been added to the list and its left branch has been added.
            // So, move to the right branch
            curr = nodeStack.pop();
            curr = curr.right;
        }
        return result;
    }
}