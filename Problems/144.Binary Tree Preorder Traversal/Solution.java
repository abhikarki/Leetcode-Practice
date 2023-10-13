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
    List <Integer> result = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // Preorder Traversal is used to create a copy of a tree. You can put the 
        // nodes in an array in preorder traversal and then perform insert operation
        // on a new tree for each value in the array. You get a copy of original tree. 
        // Preorder traversal is also useful when we are searching for an element in 
        // a binary search tree.
        // It is called a preorder because you encounter the roots before the leaves.
        traverse(root);
        return result;
    }

    
    public void traverse(TreeNode currNode){
        if(currNode == null){
            return;
        }
        //Preorder traversal.
        result.add(currNode.val);
        traverse(currNode.left);
        traverse(currNode.right);
        }
}