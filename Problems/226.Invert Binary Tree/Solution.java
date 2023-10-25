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
    public TreeNode invertTree(TreeNode root) {
        // For each node, swap the left and right nodes.
        swapNodes(root);
        return root;
    }
    public void swapNodes(TreeNode currNode){
        if (currNode == null){
            return;
        }
        TreeNode temp = currNode.left;
        currNode.left = currNode.right;
        currNode.right = temp;
        swapNodes(currNode.left);
        swapNodes(currNode.right);
    }
}