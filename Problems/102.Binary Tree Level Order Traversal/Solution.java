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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Result list.
        List <List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        // Queue to store and retrieve the nodes.
        Queue <TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        // CurrSize keeps track of the number of nodes in current level.
        int currSize = 0;
        TreeNode currNode = root;
        // List for each level of the tree.
        List <Integer> currList = null;

        while(!nodeQueue.isEmpty()){
            // Get the size of the current level.
            currSize = nodeQueue.size();
            currList = new ArrayList<>();
            // Run the loop 'currSize' times i.e. add the nodes from current level.
            while(currSize > 0){
                TreeNode temp = nodeQueue.remove();
                // Retrieve each node and add its children to the queue.
                // Adding children won't increase the currSize for this loop, so loop 
                // only runs for the nodes in the current level.

                currList.add(temp.val);

                if(temp.left != null){
                    nodeQueue.add(temp.left);
                }
                if(temp.right != null){
                    nodeQueue.add(temp.right);
                }
                // For each node retrieved, decrease the currSize.
                currSize --;
            }
            // Add the list of nodes from current level to the result list.
            result.add(currList);
        }
        return result;

    }
}