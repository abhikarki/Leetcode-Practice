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
    // Result list
    List <Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        // Recursive function for InorderTraversal
        traverse(root);
        return result;
    }

    public void traverse(TreeNode currNode){
        if(currNode == null){
            return;
        }
        // Traverse the left branch, add current node's value, traverse right branch.
        traverse(currNode.left);
        result.add(currNode.val);
        traverse(currNode.right);
    }
}