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
    // i keeps track of the index in the sorted order.
    int i = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;
    }

    public void inorder(TreeNode curr, int k){
        if (curr == null){
            return;
        }

        // inorder traversal
        inorder(curr.left,k);
        i ++;
        if(i == k){
            // i is the index in the sorted order(ascending), so if i==k,
            // it is the kth smallest element in the tree.
            result = curr.val;
        }
        inorder(curr.right,k);

    }
}