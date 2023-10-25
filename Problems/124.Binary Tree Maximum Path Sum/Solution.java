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
    // Variable for max path sum
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int a = findMax(root);
        return max;
    }

    /*
     * Recursive method to find the max. For each node, the max path sum can be the 
     * node's value itself or the sum of the node's value and max path sum of one of 
     * its child nodes.      
     * Also, we compute the sum of the node's value and max path sum of both of 
     * its child nodes. We only compare this value with the max but donot return this 
     * value to the parent node because the parent node can't form a path together 
     * with these nodes.
    */
    public int findMax(TreeNode curr){
        if(curr == null){
            return 0;
        }
        // variable to store the max path sum for current node.
        int currMax = curr.val;
        int leftMax = findMax(curr.left);
        int rightMax = findMax(curr.right);
        // Compare with the max.
        if((curr.val + leftMax + rightMax) > max){
            max = curr.val + leftMax + rightMax;
        }

        if((curr.val + leftMax) > currMax){
            currMax = curr.val + leftMax;
        }
        if((curr.val + rightMax) > currMax){
            currMax = curr.val + rightMax;
        }
        // Compare with the max.
        if(currMax > max){
            max = currMax;
        }
        // return the current max to the parent node.
        return currMax;
    }
}