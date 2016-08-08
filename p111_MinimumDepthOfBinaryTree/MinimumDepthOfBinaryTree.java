package p111_MinimumDepthOfBinaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MinimumDepthOfBinaryTree {
	int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
    	if(root == null)
    		return 0;
    	searchDepth(root, 1);
    	return min;
    }
    
    void searchDepth(TreeNode node, int depth)
    {
    	if(node.left == null && node.right == null)
    		min = Math.min(min, depth);
    	if(node.left != null)
    		searchDepth(node.left, depth+1);
    	if(node.right != null)
    		searchDepth(node.right, depth+1);   	
    }
}
