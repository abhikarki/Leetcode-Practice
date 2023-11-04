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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Find method finds a node whose value equals to the root of the subtree.
        // It then calls the check method to compare the node and its descendants with
        // the given subtree.
        return find(root, subRoot);
    }

    // Find nodes in the tree whose value equals the root of the subtree.
    // For each equal node found, check if the node and its descendants are same as
    // that of the subtree (using preorder traversal).
    public boolean find(TreeNode curr, TreeNode subRoot){
        if(curr == null){
            return false;
        }
        if(curr.val == subRoot.val){
            // Compare with the subtree.
            if (check(curr, subRoot) == true){
                return true;
            }
        }
        // Search using pre order traversal.
        if (find(curr.left, subRoot) == true || find(curr.right, subRoot) == true){
            return true;
        }
        return false;
    }

    // Compare the node's descendants with the subtree using preOrder traversal.
    public boolean check(TreeNode curr, TreeNode subCurr){
        // Both nodes are null.
        if(subCurr == null && curr == null){
            return true;
        }
        // Only one of them is null.
        if(subCurr == null || curr == null){
            return false;
        }
        // Pre order traversal
        if(curr.val == subCurr.val 
            && check(curr.left, subCurr.left) == true 
            && check(curr.right, subCurr.right) == true){
               return true;
        }
        // Nodes' values not equal.
        return false;
    }
}

