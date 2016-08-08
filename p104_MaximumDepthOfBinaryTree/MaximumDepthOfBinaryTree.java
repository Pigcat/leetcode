package p104_MaximumDepthOfBinaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MaximumDepthOfBinaryTree {
	int max = 0;
	
    public int maxDepth(TreeNode root) {
    	if(root == null)
    		return 0;
        searchDepth(root, 1);
        return max;
    }
    
    void searchDepth(TreeNode node, int depth)
    {
    	if(node.left == null && node.right == null)
    	{
    		if(depth > max)
    			max = depth;
    	}
    	if(node.left != null)
    		searchDepth(node.left, depth+1);
    	if(node.right != null)
    		searchDepth(node.right, depth+1);
    }
}
