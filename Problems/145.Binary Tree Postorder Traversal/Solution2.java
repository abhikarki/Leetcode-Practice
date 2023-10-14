class Solution2{
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        // Using two stacks.
        // Take root and add to nodeStack1. Pop nodeStack1 and add to nodeStack2.
        // Push left and right child of the top of the nodeStack2 to nodeStack1.
        // Repeat until nodeStack1 is empty. nodeStack2 contains postorder traversal.
        
        Stack<TreeNode> nodeStack1 = new Stack<>();
        Stack<TreeNode> nodeStack2 = new Stack<>();

        TreeNode curr = root;
        if(curr == null){
            return result;
        }
        nodeStack1.push(root);

        while(!nodeStack1.isEmpty()){
            curr = nodeStack1.pop();
            nodeStack2.push(curr);
            if(curr.left != null){
                nodeStack1.push(curr.left);
            }
            if(curr.right != null){
                nodeStack1.push(curr.right);
            }
        }
        while(!nodeStack2.isEmpty()){
            result.add(nodeStack2.pop().val);
        }
        return result;
    }
}