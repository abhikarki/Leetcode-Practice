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
    public int maxDepth(TreeNode root) {
        return calculateMax(root);
    }


    public int calculateMax(TreeNode currNode){
        if(currNode == null){
            return 0;
        }
        // Return the max of the depth of the currNode's children + 1.
        return Math.max(calculateMax(currNode.left), calculateMax(currNode.right)) + 1;
    }
}