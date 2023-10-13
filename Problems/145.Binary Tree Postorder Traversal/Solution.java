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
class Solution {

    // Postorder traversal can be used to delete a tree from leaf to root.
    // By traversing the left and right subtrees first (postorder), you can ensure 
    // that you're deleting child nodes before their parent nodes, which 
    // helps maintain the integrity of the tree structure.
    // Other use of postorder traversal in in expression evaluation. In expression 
    // trees, post order traversal is used to evaluate the expression.

    List <Integer> result = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }

    public void traverse(TreeNode currNode){
        if(currNode == null){
            return;
        }
        // Postorder Traversal.
        traverse(currNode.left);
        traverse(currNode.right);
        result.add(currNode.val);
    }
}