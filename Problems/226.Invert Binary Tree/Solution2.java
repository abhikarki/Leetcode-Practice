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
    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        // Keep adding the node to the queue and swap its left and right nodes.
        Queue <TreeNode> nodeQueue = new LinkedList<>();
        TreeNode curr = null;
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()){
            curr = nodeQueue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.left != null) {nodeQueue.add(curr.left);}
            if(curr.right != null) {nodeQueue.add(curr.right);}
        }
        return root;
    }
}