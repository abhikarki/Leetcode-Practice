/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // First finding the node p and storing all the nodes on the path
        // to a hashset. Then finding teh node q and for each node on the 
        // path, check if the node is in the HashSet and update the result
        // The last update to the result is the lowest common ancestor.
        HashSet <Integer> map = new HashSet<>();
        int a = p.val;
        int b = q.val;
        TreeNode result = root;
        TreeNode curr = root;
        // Finding p
        while(curr != null){
            map.add(curr.val);
            if(curr.val == a){
                break;
            }
            else if(curr.val < a){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }

        curr = root;
        // Finding q
        while(curr != null){
            // Update result
            if(map.contains(curr.val)){
                result = curr;
            }
            if(curr.val == b){
                break;
            }
            else if(curr.val < b){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        return result;

    }
}

