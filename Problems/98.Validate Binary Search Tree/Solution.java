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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean result = check(root, null, null);
        return result;
    }

    public boolean check(TreeNode curr,Integer max, Integer min){
        if (curr == null){
            return true;
        }
        if((min != null && curr.val <= min) || (max!= null && curr.val >= max)){
            return false;
        }
        else{
            return check(curr.left, curr.val, min) && check(curr.right, max, curr.val);
        }
    }
}