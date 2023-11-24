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
    // Hashmap for quick lookup in inorder array.
    HashMap <Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        // Fill the hashmap
        for(int i = 0; i < inLength; i ++){
            map.put(inorder[i], i);
        }
        if(preLength == 0){
            return null;
        }
        TreeNode root = build(preorder, inorder, 0, preLength-1, 0,     inLength-1);
        return root;

    }

    // build method builds the tree recursively.
    // The first element of the preorder always contains the root node.
    // search for the node in the inorder array. All the elements to the 
    // left in the inorder array fall in the left subtree of the node and
    // to the right fall in the right subtree of the node. Partition the
    // preorder array based on the number of left and right nodes.

    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        // For the leaf node.
        if(preStart == preEnd){
            TreeNode resultNode = new TreeNode(preorder[preStart], null,null);
            return resultNode;
        }

        // end of the tree.
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        int curr = preorder[preStart];
        TreeNode currNode = new TreeNode(curr, null, null);
        int i = map.get(curr);
       
        int a = i - inStart;
        // Left subtree
        currNode.left = build(preorder,inorder,preStart+1,preStart+a,inStart, inStart+a-1);
        // Right subtree.
        currNode.right = build(preorder,inorder,preStart+a+1,preEnd,i+1,inEnd);
        return currNode;
    }
}