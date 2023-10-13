class Solution2{
    public List<Integer> inorderTraversal (TreeNode root){
        List <Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        TreeNode curr = root;
        // Stack to keep track of nodes.
        Stack <TreeNode> nodeStack = new Stack<>();

        while(!nodeStack.empty() || curr != null){
            while(curr != null){
                nodeStack.push(curr);
                curr = curr.left;
            }
            // The top of the stack contains our next element in the traversal.
            // Update 'curr'' to this element so that traversal continues to its right.
            curr = nodeStack.pop();
            result.add(curr.val);
            // Continue to the right branch
            curr = curr.right;
        }
        return result;
    }
}