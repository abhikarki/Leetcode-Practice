/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder preOrder = null;
    int arrayPointer = 0;

    // Create a string for preOrder traversal.
    public void createPreOrder(TreeNode curr){
        // a comma is added to the end of the string but later, in deserialize method,
        // the split method discards the trailing empty strings, so it doesnot affect
        // the code.
        if(curr == null){
            preOrder.append("N,");
            return;
        }
        // PreOrder Traversal
        preOrder.append(curr.val).append(",");
        createPreOrder(curr.left);
        createPreOrder(curr.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preOrder = new StringBuilder();
        createPreOrder(root);
        // A string with the nodes are in preorder, separated by comma.
        String result = preOrder.toString();
        return (result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Split the string into an array with "," delimiter.
        // The split() method discards the trailing empty strings.
        String [] arr = data.split(",");
        arrayPointer = 0;
        TreeNode ans = createTree(arr);
        return ans;
    }

    // Create the tree using the preOrder traversal.
    public TreeNode createTree(String[] arr){
        if(arr[arrayPointer].equals("N")){
            arrayPointer ++;
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(arr[arrayPointer]));
        arrayPointer ++;
        newNode.left = createTree(arr);
        newNode.right = createTree(arr);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));