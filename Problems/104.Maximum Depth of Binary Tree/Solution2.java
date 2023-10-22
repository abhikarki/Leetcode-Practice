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
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        // Using a queue to store the nodes.
        // 'size' variable stores the size of the current level in the tree.
        // Once we go through the nodes in a level, the 'height' is updated by 1.
        Queue <TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int size = nodeQueue.size();
        int height = 0;

        // Loop run until we go through all the nodes in the current level.
        while(size != 0){
            TreeNode currNode = nodeQueue.remove();
            size --;
            if(currNode.left != null){
                nodeQueue.add(currNode.left);
            }
            if(currNode.right != null){
                nodeQueue.add(currNode.right);
            }

            // If we completed all the nodes in this level, update the height,
            // Update the size to the queue's size i.e. the no. of nodes in next level.
            if(size == 0){
                height ++;
                size = nodeQueue.size();
            }
        }
        // Return the height.
        return height;

    }
}